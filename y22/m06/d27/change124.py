def solution(n):
    return change_radix(n)


def change_radix(number):
    quotient = number // 3
    remainder = number % 3

    if remainder == 0:
        remainder = 4
        quotient -= 1

    if quotient < 3:
        if quotient == 0:
            return str(remainder)
        else:
            return str(quotient) + str(remainder)
    else:
        return change_radix(quotient) + str(remainder)


def best_solution(n):
    num = ['1', '2', '4']
    answer = ""

    while n > 0:
        n -= 1
        answer = num[n % 3] + answer
        n //= 3

    return answer


def best_solution_2(n):
    if n <= 3:
        return '124'[n - 1]
    else:
        q, r = divmod(n - 1, 3)
        return best_solution_2(q) + '124'[r]


def solution(n):
    quotient, remainder = divmod(n, 3)

    if remainder == 0:
        remainder = 4
        quotient -= 1

    if n <= 3:
        return str(remainder)
    else:
        return solution(quotient) + str(remainder)
