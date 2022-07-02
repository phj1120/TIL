def solution(dirs):
    visited = [[False for i in range(11)] for i in range(11)]
    x, y = 'x', 'y'
    now = {x: 5, y: 5}
    next_x, next_y = now[x], now[y]
    first_move_cnt = 0
    for dir in dirs:
        if dir == 'U':
            pass
        elif dir == 'D':
            next_y = now[y] - 1
        elif dir == 'R':
            next_x = now[x] + 1
        elif dir == 'L':
            next_x = now[x] - 1
        else:
            continue
        print(dir, now, next_x, next_y)
        if next_x > 11 or next_x < 0 or next_y > 11 or next_y < 0:
            continue
        now[x], now[y] = next_x, next_y

        if not visited[now[x]][now[y]]:
            visited[now[x]][now[y]] = True
            first_move_cnt += 1
            print(first_move_cnt)
    return first_move_cnt


def solution(dirs):
    visited = dict()
    x, y = 0, 0
    for dir in dirs:
        if dir == 'U' and y > 5:
            y += 1
            visited[(x, y, x, y + 1)] = True
        elif dir == 'D' and y < -5:
            y -= 1
            visited[(x, y-1, x, y)] = True
        elif dir == 'L' and x < -5:
            visited[(x-1, y, x, y)] = True
        elif dir == 'R' and x > 5:
            visited[(x, y, x + 1, y)] = True
    return len(visited)


def best_solution(dirs):
    visited = dict()
    x, y = 0, 0
    for dir in dirs:
        if dir == 'U' and y < 5:
            visited[(x, y, x, y + 1)] = True
            y += 1
        elif dir == 'D' and y > -5:
            visited[(x, y-1, x, y)] = True
            y -= 1
        elif dir == 'L' and x > -5:
            visited[(x-1, y, x, y)] = True
            x -= 1
        elif dir == 'R' and x < 5:
            visited[(x, y, x + 1, y)] = True
            x += 1

    return len(visited)