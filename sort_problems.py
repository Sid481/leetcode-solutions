import os
import json
import shutil

BASE_PATH = os.getcwd()

def load_problem_difficulty():
    stats_path = os.path.join(BASE_PATH, "stats.json")
    if not os.path.exists(stats_path):
        print("❌ stats.json not found.")
        return {}

    with open(stats_path, "r") as f:
        stats = json.load(f)

    shas = stats.get("leetcode", {}).get("shas", {})
    difficulty_map = {}

    for key, value in shas.items():
        if isinstance(value, dict):
            if "difficulty" in value:
                # Extract problem ID from folder name
                for part in key.split("-"):
                    if part.isdigit():
                        problem_id = part.zfill(4)  # Normalize ID to 4 digits
                        difficulty = value["difficulty"].capitalize()  # e.g., "medium" -> "Medium"
                        difficulty_map[problem_id] = difficulty
                        break

    return difficulty_map

def move_problems(difficulty_map):
    for folder in os.listdir(BASE_PATH):
        folder_path = os.path.join(BASE_PATH, folder)

        if os.path.isdir(folder_path) and folder[:4].isdigit():
            problem_id = folder[:4]
            difficulty = difficulty_map.get(problem_id)

            if not difficulty:
                print(f"❌ No difficulty found for {problem_id} - {folder}")
                continue

            dest_dir = os.path.join(BASE_PATH, difficulty, folder)
            os.makedirs(dest_dir, exist_ok=True)

            for file in os.listdir(folder_path):
                shutil.move(os.path.join(folder_path, file), os.path.join(dest_dir, file))

            os.rmdir(folder_path)
            print(f"✅ Moved {folder} → {difficulty}/")

if __name__ == "__main__":
    difficulty_map = load_problem_difficulty()
    move_problems(difficulty_map)
