from datetime import datetime
import os


# 오늘의 작업 폴더 생성
def create_directory(directory):
    try:
        if not os.path.exists(directory):
            print('Success : ', directory)
            os.makedirs(directory)
        else:
            print("Success : Directory already exists.")
    except OSError:
        print("Error: Failed to create the directory.")


# 오늘의 작업 폴더에 README 파일 생성
def create_readme(directory):
    readme_path = os.path.join(directory, "README.md")

    try:
        if not os.path.exists(readme_path):
            f = open(readme_path, "w")
            today_str = datetime.strftime(datetime.now(), "%Y.%m.%d.\n")
            f.write(f'# {today_str}')
        else:
            print("Success : README file already exists.")
    except OSError:
        print("Error: Failed to create the README file.")


# Todo 월 말 회고 README 파일 생성


if __name__ == "__main__":
    now = datetime.now()
    year = 'y%d' % (now.year - 2000)
    month = 'm%02d' % now.month
    day = 'd%02d' % now.day

    if os.name == 'posix':  # mac
        dir_path = '/Users/phj/Dev/git/TIL'
    else:  # windows
        dir_path = os.getcwd()

    path = os.path.join(dir_path, year, month, day)

    create_directory(path)
    create_readme(path)
