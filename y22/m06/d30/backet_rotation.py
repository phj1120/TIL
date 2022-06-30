def solution(s):
    correct_count = 0

    for i in range(len(s)):
        brackets = s[i:] + s[:i]
        bracket_stack = []

        first_bracket = brackets[0]
        if first_bracket == '}' or first_bracket == ')' or first_bracket == ']':
            continue

        for index in range(len(brackets)):
            bracket = brackets[index]

            # print(len(brackets)-1, index, bracket)
            if index == (len(brackets) - 1) and len(bracket_stack) == 1:
                print(bracket_stack)
                correct_count += 1

            if bracket == '(':
                bracket_stack.append('(')
            elif bracket == ')':
                if len(bracket_stack) != 0:
                    pop_bracket = bracket_stack.pop()
                    if pop_bracket != '(':
                        break
                else:
                    break
            elif bracket == '{':
                bracket_stack.append('{')
            elif bracket == '}':
                if len(bracket_stack) != 0:
                    pop_bracket = bracket_stack.pop()
                    if pop_bracket != '{':
                        break
                else:
                    break
            elif bracket == '[':
                bracket_stack.append('[')
            elif bracket == ']':
                if len(bracket_stack) != 0:
                    pop_bracket = bracket_stack.pop()
                    if pop_bracket != '[':
                        break
                else:
                    break
    return correct_count


def best_solution(s):
    cnt = 0
    for i in range(len(s)):
        u = s[:i]
        v = s[i:]

        if check(v + u):
            cnt += 1
    return cnt


def check(str_list):
    stack = []

    for _str in str_list:
        if _str in ('[', '(', '{'):
            stack.append(_str)
        else:
            if not stack: return False
            x = stack.pop()
            if _str == ']' and x != '[':
                return False
            elif _str == ')' and x != '(':
                return False
            elif _str == '}' and x != '{':
                return False

    if stack: return False
    return True
