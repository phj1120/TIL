# 96 / 100
# no 반복 -> 반복 넘어갈 때 반복한 횟 수를 다른 곳에 저장해서 생긴 오류였음
# "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" / 7 테스트케이스 추가해서 잡음
#
# arr[i-1] arr[i] arr[i+1] 이
# b a a 일 경우 b 2 a 로 바뀌어야 되는데
"""
if arr[i] != arr[i + 1]:
    continue
if arr[i - 1] == str(cnt):
    cnt += 1
    arr[i] = str(cnt)
    arr[i - 1] = ""
else:
    arr[i] = "2"
"""


# 여기선 b a a 가 들어오면
# b == str(cnt) -> cnt 31(전에 사용된 값) 로
# 개수 세는데 필요한 if 문의 로직대신
# else 문 실행 됨 arr[i] = 2
# 2 a a 반복.
# cnt = 2 추가해서 이 문제 해결

# 하나 틀렸는데 뭘까...


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
                cnt = 2

        result = 0
        for i in arr:
            # print(i, len(i))
            result += len(i)
        # print(result)
        min_result = min(min_result, result)
    return min_result
