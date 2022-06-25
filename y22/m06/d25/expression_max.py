def solution(expression):
    from itertools import permutations

    expression = expression.replace('+', ' + ').replace('-', ' - ').replace('*', ' * ')
    expression_list = expression.split(' ')

    op_define = ['*', '+', '-']
    op_list = list(permutations(op_define, len(op_define)))

    max_expression = 0
    for ops in op_list:  # 3!
        new_expression_list = expression_list[:]
        for op in ops:  # 3
            idx = 0
            while True:  # len(expression) => 3! * 3 * len(expression) : 3 중 반복문 괜찮다고 판단
                if idx == len(new_expression_list): break
                if new_expression_list[idx] == op:
                    calc_result = custom_calc(new_expression_list[idx - 1], new_expression_list[idx + 1],
                                              new_expression_list[idx])
                    new_expression_list[idx - 1] = calc_result
                    new_expression_list.pop(idx)
                    new_expression_list.pop(idx)
                else:
                    idx += 1
        max_expression = max(max_expression, abs(int(new_expression_list[0])))
    return max_expression


def custom_calc(a, b, op):
    if op == '*':
        return int(a) * int(b)
    elif op == '-':
        return int(a) - int(b)
    elif op == '+':
        return int(a) + int(b)
    return -1


expression = "100-200*300-500+20"
print(solution(expression))
