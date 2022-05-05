# 100 / 100
# 문자열 길이가 1일 경우를 고려하지 않아 생긴 오류
# 조건 범위 확인 후 범위 값 테스트 해봄
# for ~ (1, 1) 로 for 문 안 돌아가서 min_result = 1e9
#
# 길이가 1일 경우 1 반환하도록 했는데 이건 하드 코딩 아닌가 하는 의문이 남음
# 문제는 해결했는데 좋은 코드인거 같지는 않음
# 다름 사람 코드 보자.

def solution(s):
    if (len(s) == 1):
        return 1;

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
            # print(i, arr[i-1], arr[i], arr[i+1])
            if arr[i] != arr[i + 1]:
                continue
            if arr[i - 1] == str(cnt):
                cnt += 1
                arr[i] = str(cnt)
                arr[i - 1] = ""
            else:
                arr[i] = "2"
                cnt = 2

        result = 0
        # print(arr)
        for i in arr:
            # print(i, len(i))
            result += len(i)
        # print(result)
        min_result = min(min_result, result)
    print(min_result)
    return min_result
