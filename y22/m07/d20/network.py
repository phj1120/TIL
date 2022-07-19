def solution(n, computers):
    count = 0
    isVisited = [False for i in range(n)]

    while True:
        next = next_visited_idx(isVisited)
        # print(next)
        if next == -1: break
        q = []
        q.append(next)
        while q:
            now = q.pop(0)
            # print(now)
            isVisited[now] = True
            for i in range(n):
                if now == i: continue
                if not isVisited[i] and computers[now][i] == 1:
                    q.append(i)
        count += 1

    return count


def next_visited_idx(isVisited):
    next_idx = -1
    for idx in range(len(isVisited)):
        if not isVisited[idx]:
            next_idx = idx
            break
    return next_idx


print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
