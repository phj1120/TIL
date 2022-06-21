def solution(array, commands):
    answer = []
    for command in commands:
        start = command[0] - 1
        end = command[1]
        index = command[2] - 1

        sub_array = array[start:end]
        sub_array.sort()
        answer.append(sub_array[index])
    return answer


def best_solution(array, commands):
    answer = []
    for command in commands:
        start, end, index = command
        answer.append(list(sorted(array[start - 1:end]))[index - 1])

    return answer


def goinmul_solution(array, commands):
    return list(map(lambda x: sorted(array[x[0] - 1:x[1]])[x[2] - 1], commands))
