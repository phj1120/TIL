count = 0


def solution(numbers, target):
    global count
    recursive(numbers, target, 1, 1, 1)
    recursive(numbers, target, 1, -1, 1)
    return count


def recursive(numbers, target, idx, op, value):
    global count
    value += numbers[idx] * op
    if idx == len(numbers) - 1:
        if value == target:
            count += 1
        return
    recursive(numbers, target, idx + 1, 1, value)
    recursive(numbers, target, idx + 1, -1, value)


def solution(numbers, target):
    answer = dfs(numbers, target, 0)
    return answer


def dfs(numbers, target, depth):
    answer = 0
    if depth == len(numbers):
        if sum(numbers) == target:
            return 1
        return 0
    else:
        answer += dfs(numbers, target, depth+1)
        numbers[depth] *= -1
        answer += dfs(numbers, target, depth+1)
        return answer
