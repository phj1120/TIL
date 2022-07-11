n, m = map(int, input().split())
A = list(map(int, input().split()))

correct_cnt = 0
sum = A[0]
s, e = 0, 0

while s < n - 1 and e < n - 1:
    if sum < m:
        e += 1
        sum += A[e]
    elif sum > m:
        sum -= A[s]
        s += 1
    if sum == m:
        correct_cnt += 1
        sum -= A[s]
        s += 1

if A[-1] == m:
    correct_cnt += 1

print(correct_cnt)
