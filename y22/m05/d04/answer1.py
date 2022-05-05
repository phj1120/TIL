# 56 / 100
# 시간대 보니까 시간 초과는 아닌듯

def solution(s):
    divisors = []
    for i in range(1, len(s) // 2 + 1):
        if len(s) % i == 0:
            divisors.append(i)

    min_result = int(1e9)
    for divisor in range(1, len(s) // 2 + 1):
        arr = []
        for i in range(len(s) // divisor + 1):
            arr.append(s[i * divisor:i * divisor + divisor])

        cnt = 1
        if arr[0] == arr[1]:
            arr[0] = "2"
            cnt = 2

        for i in range(1, len(arr) - 1):
            if arr[i] != arr[i + 1]:
                continue
            if arr[i - 1] == str(cnt):
                cnt += 1
                arr[i] = str(cnt)
                arr[i - 1] = ""
            else:
                arr[i] = "2"

        result = 0
        for i in arr:
            # print(i, len(i))
            result += len(i)
        # print(result)
        min_result = min(min_result, result)
    return min_result
