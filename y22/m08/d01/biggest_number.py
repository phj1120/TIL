def solution(numbers):
    numbers_str = []
    for number in numbers:
        numbers_str.append(str(number))
    numbers_str.sort(reverse=True, key=lambda x: x * 3)
    return str(int("".join(numbers_str)))


print(solution([6, 10, 2]) == "6210")
print(solution([3, 30, 34, 5, 9]) == "9534330")
