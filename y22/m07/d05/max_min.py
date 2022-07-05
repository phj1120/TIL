def solution(s):
    numbers = list(map(int, s.split(' ')))
    min_number = min(numbers)
    max_number = max(numbers)

    return f'{min_number} {max_number}'
