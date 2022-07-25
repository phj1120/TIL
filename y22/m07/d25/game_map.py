def solution(maps):
    n, m = len(maps[-1]), len(maps)
    queue = [(0, 0)]
    while queue:
        x, y = queue.pop(0)
        # 상
        if y > 0 and maps[y - 1][x] == 1:
            maps[y - 1][x] = maps[y][x] + 1
            queue.append((x, y - 1))
        # 하
        if y < m - 1 and maps[y + 1][x] == 1:
            maps[y + 1][x] = maps[y][x] + 1
            queue.append((x, y + 1))
        # 좌
        if x > 0 and maps[y][x - 1] == 1:
            maps[y][x - 1] = maps[y][x] + 1
            queue.append((x - 1, y))
        # 우
        if x < n - 1 and maps[y][x + 1] == 1:
            maps[y][x + 1] = maps[y][x] + 1
            queue.append((x + 1, y))

        if maps[-1][-1] != 1:
            return maps[-1][-1]

    return -1


def solution(maps):
    n, m = len(maps[-1]), len(maps)
    queue = [(0, 0)]
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while queue:
        x, y = queue.pop(0)

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if maps[ny][nx] == 1:
                    maps[ny][nx] = maps[y][x] + 1
                    queue.append((nx, ny))

        if maps[-1][-1] != 1:
            return maps[-1][-1]

    return -1
