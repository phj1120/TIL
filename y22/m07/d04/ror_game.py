def solution(maps):
    from collections import deque
    n, m = len(maps[-1]), len(maps)
    queue = deque([(0, 0)])
    while queue:
        x, y = queue.popleft()

        # 상
        if y - 1 >= 0 and maps[y - 1][x] == 1:
            maps[y - 1][x] = maps[y][x] + 1
            queue.append((x, y - 1))
        # 하
        if y + 1 < m and maps[y + 1][x] == 1:
            maps[y + 1][x] = maps[y][x] + 1
            queue.append((x, y + 1))
        # 좌
        if x - 1 >= 0 and maps[y][x - 1] == 1:
            maps[y][x - 1] = maps[y][x] + 1
            queue.append((x - 1, y))
        # 우
        if x + 1 < n and maps[y][x + 1] == 1:
            maps[y][x + 1] = maps[y][x] + 1
            queue.append((x + 1, y))

        if maps[-1][-1] != 1:
            return maps[-1][-1]

    return -1


def other_solution(maps):
    from collections import deque

    x_move = [1, 0, -1, 0]
    y_move = [0, 1, 0, -1]

    x_h, y_h = (len(maps[0]), len(maps))
    queue = deque([(0, 0, 1)])

    while queue:
        x, y, d = queue.popleft()

        for i in range(4):
            nx = x + x_move[i]
            ny = y + y_move[i]

            if nx > -1 and ny > -1 and nx < x_h and ny < y_h:
                if maps[ny][nx] == 1 or maps[ny][nx] > d + 1:
                    maps[ny][nx] = d + 1
                    if nx == x_h - 1 and ny == y_h - 1:
                        return d + 1

                    queue.append((nx, ny, d + 1))

    return -1


def mix_solution(maps):
    from collections import deque

    # 우, 상, 좌, 하
    x_move = [1, 0, -1, 0]
    y_move = [0, 1, 0, -1]

    x_h, y_h = (len(maps[0]), len(maps))
    queue = deque([(0, 0)])

    while queue:
        x, y = queue.popleft()
        d = maps[y][x]
        for i in range(4):
            nx = x + x_move[i]
            ny = y + y_move[i]

            if nx > -1 and ny > -1 and nx < x_h and ny < y_h:
                if maps[ny][nx] == 1 or maps[ny][nx] > d + 1:
                    maps[ny][nx] = d + 1
                    if nx == x_h - 1 and ny == y_h - 1:
                        return d + 1

                    queue.append((nx, ny))

    return -1
