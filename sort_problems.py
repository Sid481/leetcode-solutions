import os
import shutil

# Mapping of problem number to difficulty
problem_difficulty = {
    "0039": "Medium",
    "0001": "Easy",
    "0072": "Hard",
    # Add more mappings here
}

BASE_PATH = os.getcwd()

def move_file(problem_id, name):
    difficulty = problem_difficulty.get(problem_id)
    if not difficulty:
        print(f"No difficulty found for {problem_id}")
        return
    
    src_dir = os.path.join(BASE_PATH, name)
    dest_dir = os.path.join(BASE_PATH, difficulty, name)

    if not os.path.exists(dest_dir):
        os.makedirs(dest_dir)
    
    for file in os.listdir(src_dir):
        shutil.move(os.path.join(src_dir, file), os.path.join(dest_dir, file))
    
    os.rmdir(src_dir)
    print(f"Moved {name} to {difficulty}/")

# Example run
move_file("0039", "0039-combination-sum")
