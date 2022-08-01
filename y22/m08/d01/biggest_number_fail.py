def solution(numbers):
    print(numbers)

    answer = ''
    while numbers:
        now_sort_list = []
        max_left_number = get_max_left_number(numbers)

        idx = 0
        while len(numbers) > idx:
            number = numbers[idx]
            left_number = get_left_number(number)
            if left_number == max_left_number:
                now_sort_list.append(str(numbers.pop(idx)))
                continue
            idx += 1

        print(now_sort_list)

        if len(now_sort_list) == 1:
            answer += now_sort_list[0]
        else:
            for number in now_sort_list:
                pass

    print(answer)
    return answer


def int_to_char_arr(number):
    str_number = str(number)
    char_arr = []
    for i in range(len(str_number)):
        char_arr.append(str_number[i])
    return char_arr


def char_arr_to_str(char_arr):
    str = ''
    for char in char_arr:
        str += char
    return str


def get_max_left_number(numbers):
    max_left_number = -1
    for number in numbers:
        left_number = str(number)[0]
        if int(max_left_number) < int(left_number):
            max_left_number = left_number
    return int(max_left_number)


def get_left_number(number):
    return int(str(number)[0])


print(solution([6, 10, 2]) == "6210")
print(solution([3, 30, 34, 5, 9]) == "9534330")
