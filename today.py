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
    readme_path = f'{directory}\README.md'
    try:
        if not os.path.exists(readme_path):
            f = open(readme_path, "w")
            today_str = datetime.strftime(datetime.now(), "%Y.%m.%d.\n")
            f.write(f'# {today_str}')
        else:
            print("Success : README file already exists.")
    except OSError:
        print("Error: Failed to create the README file.")


if __name__ == "__main__":
    now = datetime.now()
    year = 'y%d' % (now.year - 2000)
    month = 'm%02d' % now.month
    day = 'd%02d' % now.day
    path = os.path.join(os.getcwd(), year, month, day)

    create_directory(path)
    create_readme(path)
