import os
import shutil

# Mapping of problem number to difficulty
problem_difficulty = {
    "0039": "Medium",
    "0001": "Easy",
    "0072": "Hard",
    "0022": "Medium",
    # Add more mappings as needed
}

BASE_PATH = os.getcwd()

def move_problems():
    for folder in os.listdir(BASE_PATH):
        folder_path = os.path.join(BASE_PATH, folder)
        
        if os.path.isdir(folder_path) and folder[:4].isdigit():
            problem_id = folder[:4]
            difficulty = problem_difficulty.get(problem_id)
            
            if not difficulty:
                print(f"❌ No difficulty mapping found for {problem_id} - {folder}")
                continue

            dest_dir = os.path.join(BASE_PATH, difficulty, folder)

            if not os.path.exists(dest_dir):
                os.makedirs(dest_dir)

            for file in os.listdir(folder_path):
                shutil.move(os.path.join(folder_path, file), os.path.join(dest_dir, file))

            os.rmdir(folder_path)
            print(f"✅ Moved {folder} → {difficulty}/")

if __name__ == "__main__":
    move_problems()
