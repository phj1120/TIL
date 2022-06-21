def solution(numbers):
    sums = []

    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if i == j: continue
            sum = numbers[i] + numbers[j]
            if sum not in sums:
                sums.append(sum)
    sums.sort()
    return sums


def best_solution(numbers):
    answer = []
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            answer.append(numbers[i] + numbers[j])
    return sorted(list(set(answer)))
