def solution(relation):
    from itertools import combinations

    arr = []
    for i in range(0, len(relation[0])):
        arr.append(i)

    combination_list = []
    for i in range(1, len(arr) + 1):
        combination_list += list(combinations(arr, i))
        # combination_list.append(list(combinations(arr, i))) # 다름
    uniqueness_combination_list = []
    for combination in combination_list:
        rows = []
        for relation_idx in range(len(relation)):
            row = ''
            for i in combination:
                row = row + '-' + str(relation[relation_idx][i])
            rows.append(row)
        if len(rows) == len(set(rows)):
            uniqueness_combination_list.append(set(combination))

    i = 0
    while len(uniqueness_combination_list) > i:
        j = 0
        while len(uniqueness_combination_list) > j:
            # print(i, j, uniqueness_combination_list[i], uniqueness_combination_list[j])
            if uniqueness_combination_list[i] == uniqueness_combination_list[j]:
                j += 1
                continue
            if uniqueness_combination_list[i] <= uniqueness_combination_list[j]:
                uniqueness_combination_list.pop(j)
            else:
                j += 1
        i += 1

    return len(uniqueness_combination_list)


def best_solution(relation):
    from itertools import combinations

    row = len(relation)
    col = len(relation[0])

    # 가능한 속성의 모든 인덱스 조합
    combi = []
    for i in range(1, col + 1):
        combi.extend(combinations(range(col), i))

    # 유일성
    unique = []
    for i in combi:
        tmp = [tuple([item[key] for key in i]) for item in relation]

        if len(set(tmp)) == row:  # 유일성
            put = True

            for x in unique:
                if set(x).issubset(set(i)):  # 최소성
                    put = False
                    break

            if put: unique.append(i)

    return len(unique)
