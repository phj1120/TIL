def solution(n, arr1, arr2):
    answer = []
    map1 = decode_map(n, arr1)
    map2 = decode_map(n, arr2)

    for i in range(0, n):
        line = ""
        for j in range(0, n):
            if map1[i][j] == '0' and map2[i][j] == '0':
                line += " "
            else:
                line += "#"
        answer.append(line)
    return answer


def ten_to_binary(n):
    if n == 0:
        return '0'
    if n <= 1:
        return '1'
    return ten_to_binary(n // 2) + str(n % 2)


def decode_map(n, arr):
    result = []
    for num in arr:
        binary = ten_to_binary(num)
        length = len(binary)
        result.append((n - length) * '0' + ten_to_binary(num))
    return result
