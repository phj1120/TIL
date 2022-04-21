# arr 에서 value 보다 작거나 같은 값의 수
def leq(arr, value):
    ret = 0
    lidx, ridx = 0, len(arr) - 1
    while lidx <= ridx:
        midx = (lidx + ridx) // 2
        if arr[midx] <= value:
            ret = max(ret, midx + 1)
            lidx = midx + 1
        else:
            ridx = midx - 1
    return ret


# arr 에서 value 보다 크거나 같은 값의 수
def geq(arr, value):
    return len(arr) - leq(arr, value - 1)


class Solution(object):
    def findMedianSortedArrays(self, num1, num2):
        A, B = (num1, num2) if len(num1) < len(num2) else (num2, num1)

        if len(A) == 0: return (B[len(B) // 2] + B[(len(B) - 1) // 2]) // 2

        N = len(A) + len(B)
        P = (N + 1) // 2

        l, r = min(A[0], B[0]), max(A[-1], B[-1])
        cand1 = 123456789
        while l <= r:
            m = (l + r) // 2
            if leq(A, m) + leq(B, m) >= P:
                cand1 = min(cand1, m)
                r = m - 1
            else:
                l = m + 1

        l, r = min(A[0], B[0]), max(A[-1], B[-1])
        cand2 = -123456789
        while l <= r:
            m = (l + r) // 2
            if geq(A, m) + geq(B, m) >= P:
                cand2 = max(cand2, m)
                l = m + 1
            else:
                r = m - 1

        return (cand1 + cand2) / 2
