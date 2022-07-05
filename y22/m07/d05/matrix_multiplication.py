def solution(arr1, arr2):
    arr1_col_length = len(arr1)
    arr1_row_length = len(arr1[0])
    arr2_row_length = len(arr2[0])

    answer = [[0 for i in range(arr2_row_length)] for j in range(arr1_col_length)]

    for i in range(arr1_col_length):
        for j in range(arr2_row_length):
            sum_each = 0
            for k in range(arr1_row_length):
                sum_each += arr1[i][k] * arr2[k][j]
            answer[i][j] = sum_each

    return answer
