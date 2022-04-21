def leq(arr, value):  # arr 에서 value 보다 작거나 같은 값의 수
    ret = 0
    lidx, ridx = 0, len(arr) - 1
    while lidx <= ridx:  # 이진 탐색
        midx = (lidx + ridx) // 2
        if arr[midx] <= value:  # 중간 값이 찾고자하는 값보다 작거나 같을 경우, 오른쪽 배열 재탐색을 위해 값 변경
            ret = max(ret, midx + 1)
            lidx = midx + 1
        else:  # 중간 값이 찾고자하는 값보다 크거나 같을 경우, 왼쪽 배열 재탐색을 위해 값 변경
            ridx = midx - 1
    return ret


def geq(arr, value):  # arr 에서 value 보다 크거나 같은 값의 수
    # 같거나 크다 의 역 -> 작다
    # arr = [1, 2, 3, 3, 5]
    # leq(arr, 3) -> 4
    # geq(arr, 3) -> 1
    # 3 보다 크거나 같은 값의 수는 전체의 길이에서 (3 - 1) 보다 작은 값의 수와 동일
    return len(arr) - leq(arr, value - 1)


class Solution(object):
    def findMedianSortedArrays(self, num1, num2):
        """
        두 배열 num1 와 num2 를 합쳤을 때의 중앙 값을 찾는 문제
        !param num1: 오름차순 정렬된 배열
        !param num2: 오름차순 정렬된 배열
        !return: 원소가 홀수 -> 중앙값 or 원소가 짝수 -> 두 중앙값의 평균
        """

        # A 에 짧은 배열 , B 에 긴 배열을 넣어 처리하기 더 쉽도록.
        A, B = (num1, num2) if len(num1) < len(num2) else (num2, num1)

        # A 길이가 0 인 경우 B 에서 중간 값 찾음
        if len(A) == 0: return (B[len(B) // 2] + B[(len(B) - 1) // 2]) // 2  # len(B) 가 홀수, 짝수인 경우 동일

        N = len(A) + len(B)
        P = (N + 1) // 2

        # 왼쪽 중앙값 후보, 오른쪽 중앙값 후보
        l, r = min(A[0], B[0]), max(A[-1], B[-1])
        cand1 = 123456789  # 왼쪽 중앙값 후보 -> 자기 leq 값이 P 이상인 가장 작은 숫자
        while l <= r:  # 중앙까지 반복
            m = (l + r) // 2
            if leq(A, m) + leq(B, m) >= P:  # 합친 배열의 좌측 값이 A와 B 배열의 중간 값보다 크거나 같으면
                cand1 = min(cand1, m)
                r = m - 1
            else:
                l = m + 1

        # 왼쪽 중앙값 후보, 오른쪽 중앙값 후보
        l, r = min(A[0], B[0]), max(A[-1], B[-1])
        cand2 = -123456789  # 오른쪽 중앙값 후보
        while l <= r:
            m = (l + r) // 2
            if geq(A, m) + geq(B, m) >= P:  # 합친 배열의 우측 값이 중간 값보다 크거나 같으면
                cand2 = max(cand2, m)
                l = m + 1
            else:
                r = m - 1

        return (cand1 + cand2) / 2
