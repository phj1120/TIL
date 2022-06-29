def solution(arr):
    n = len(arr)
    check_area(arr, 0, 0, n)

    oneCnt = 0
    zeroCnt = 0
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 0:
                zeroCnt += 1
            elif arr[i][j] == 1:
                oneCnt += 1
    return [zeroCnt, oneCnt]


def check_area(arr, startX, startY, length):
    if length == 1:
        return
    if arr[startX][startY] == '':
        return

    if is_all_same_value(arr, startX, startY, length):
        value = arr[startX][startY]
        for i in range(startX, startX + length):
            for j in range(startY, startY + length):
                arr[i][j] = ''
        arr[startX][startY] = value
    else:
        next_length = length // 2
        check_area(arr, startX, startY, next_length)
        check_area(arr, startX + next_length, startY, next_length)
        check_area(arr, startX, startY + next_length, next_length)
        check_area(arr, startX + next_length, startY + next_length, next_length)


def is_all_same_value(arr, startX, startY, length):
    value = arr[startX][startY]
    for i in range(startX, startX + length):
        for j in range(startY, startY + length):
            if arr[i][j] != value:
                return False
    return True


def best_solution(arr):
    answer = [0, 0]

    def check(size, x, y):
        if size == 1:
            answer[arr[y][x]] += 1
            return
        else:
            first = arr[y][x]

            for dy in range(size):
                for dx in range(size):
                    if first != arr[y + dy][x + dx]:
                        check(size // 2, x, y)
                        check(size // 2, x + size // 2, y)
                        check(size // 2, x, y + size // 2)
                        check(size // 2, x + size // 2, y + size // 2)
                        return
            answer[first] += 1

    check(len(arr), 0, 0)

    return answer
