def solution(number, k):
    i = 0
    while True:
        sub_number = number[i:i + k + 1]

        if k <= 0:
            break

        if sub_number == '':
            number = number[:i - 1]
            break

        if sub_number[0] == '9':
            i += 1
            continue

        max_number = 0
        max_number_index = 0

        for index in range(len(sub_number)):
            if int(sub_number[index]) > int(max_number):
                max_number_index = index
                max_number = sub_number[index]
        number = number[:i] + number[i + max_number_index:]

        k -= max_number_index
        i += 1
    return number


def solution(number, k):
    answer = []

    for i in number:
        if not answer:
            answer.append(i)
            continue
        while answer[-1] < i and k > 0:
            answer.pop()
            k -= 1
            if not answer or k <= 0:
                break
        answer.append(i)
        if len(answer) == len(number) - k:
            break
    return ''.join(answer)


def solution(number, k):
    stack = []
    for num in number:
        while stack and stack[-1] < num and k > 0:
            k -= 1
            stack.pop()
        stack.append(num)
    if k != 0:
        stack = stack[:-k]
    return ''.join(stack)
