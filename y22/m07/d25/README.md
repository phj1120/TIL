# 2022.07.25.

최근 푼 DFS / BFS 문제를 다시 풀어 보고 코드를 정리 해봤다.

## 타겟 넘버

[타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165)

```
def solution(numbers, target):
    def dfs(numbers, target, index):
        same_count = 0
        if index == len(numbers):
            if sum(numbers) == target:
                return 1
            return 0

        same_count += dfs(numbers, target, index + 1)
        numbers[index] *= -1
        same_count += dfs(numbers, target, index + 1)
        return same_count

    same_count = dfs(numbers, target, 0)

    return same_count
```

```
def solution(numbers, target):
    answer = 0
    q = []
    n = len(numbers)
    q.append((numbers[0], 0))
    q.append((-1 * numbers[0], 0))
    while q:
        temp, idx = q.pop()
        idx += 1
        if idx < n:
            q.append((temp + numbers[idx], idx))
            q.append((temp - numbers[idx], idx))
        else:
            if temp == target:
                answer += 1
    return answer
```

## 게임 맵 최단 거리

[게임 맵 최단 거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844)

```
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
```

```
def solution(maps):
    n, m = len(maps[-1]), len(maps)
    queue = [(0, 0)]
    delta = ((-1, 0), (1, 0), (0, 1), (0, -1))

    while queue:
        x, y = queue.pop(0)

        for dx, dy in delta:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < m:
                if maps[ny][nx] == 1:
                    maps[ny][nx] = maps[y][x] + 1
                    queue.append((nx, ny))

        if maps[-1][-1] != 1:
            return maps[-1][-1]

    return -1
```