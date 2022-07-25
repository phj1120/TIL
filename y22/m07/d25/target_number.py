# 다시 풀어본 풀이

same_count = 0


def solution(numbers, target):
    global same_count

    def dfs(numbers, target, index):
        global same_count
        if index == len(numbers) - 1:
            if sum(numbers) == target:
                same_count += 1
            return

        dfs(numbers, target, index + 1)
        numbers[index + 1] *= -1
        dfs(numbers, target, index + 1)

    dfs(numbers, target, -1)

    return same_count


# DFS 풀이
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


# BFS 풀이
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
