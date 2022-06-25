def solution(n):
    arrs = []
    for i in range(1, n + 1):
        arrs.append([0] * i)

    type = 0
    num = 1
    x, y = -1, 0

    for i in range(n, 0, -1):
        for j in range(i):
            if type % 3 == 0:
                x += 1
            elif type % 3 == 1:
                y += 1
            else:
                y -= 1
                x -= 1
            arrs[x][y] = num
            num += 1
        type += 1
    answer = []

    for arr in arrs:
        answer += arr

    return answer
