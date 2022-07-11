n, m = map(int, input().split())
arr = list(map(int, input().split()))
count, start, end, sum = 0, 0, 0, arr[0]
while True:
    if sum == m:
        count += 1
    if sum <= m:
        end += 1
        if end == n:
            break
        sum += arr[end]
    else:
        sum -= arr[start]
        start += 1
        if start == n:
            break
print(count)
