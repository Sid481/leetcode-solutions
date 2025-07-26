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

    difficulty_map = {}
    for stat in stats.get("stat_status_pairs", []):
        frontend_id = stat["stat"]["frontend_question_id"]
        difficulty_level = stat["difficulty"]["level"]

        # Format ID to 4-digit string, like 0039
        formatted_id = str(frontend_id).zfill(4)

        # Map number to string difficulty
        if difficulty_level == 1:
            difficulty_str = "Easy"
        elif difficulty_level == 2:
            difficulty_str = "Medium"
        elif difficulty_level == 3:
            difficulty_str = "Hard"
        else:
            continue

        difficulty_map[formatted_id] = difficulty_str

    return difficulty_map

def move_problems(difficulty_map):
    for folder in os.listdir(BASE_PATH):
        folder_path = os.path.join(BASE_PATH, folder)

        # Only process folders like "0039-combination-sum"
        if os.path.isdir(folder_path) and folder[:4].isdigit():
            problem_id = folder[:4]
            difficulty = difficulty_map.get(problem_id)

            if not difficulty:
                print(f"❌ No difficulty found for {problem_id} - {folder}")
                continue

            dest_dir = os.path.join(BASE_PATH, difficulty, folder)

            if not os.path.exists(dest_dir):
                os.makedirs(dest_dir)

            for file in os.listdir(folder_path):
                shutil.move(os.path.join(folder_path, file), os.path.join(dest_dir, file))

            os.rmdir(folder_path)
            print(f"✅ Moved {folder} → {difficulty}/")

if __name__ == "__main__":
    difficulty_map = load_problem_difficulty()
    move_problems(difficulty_map)
