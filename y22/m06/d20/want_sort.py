def solution(strings, n):
    length = len(strings)

    for i in range(length):
        min_criterion = 'z'
        min_val = 'z' * len(strings[0])

        for j in range(i, length):
            criterion = strings[j][n]
            if criterion <= min_criterion:
                if criterion == min_criterion and strings[j] >= min_val:
                    continue
                min_criterion = criterion
                min_val = strings[j]
                min_idx = j

        strings[i], strings[min_idx] = strings[min_idx], strings[i]

    return strings


def best_solution(strings, n):
    strings.sort()

    return sorted(strings, key=lambda x: x[n])
