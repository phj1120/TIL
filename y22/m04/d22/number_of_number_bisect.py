import bisect

n, x = map(int, input().split())
arr = list(map(int, input().split()))

cnt = bisect.bisect_right(arr, x) - bisect.bisect_left(arr, x)

if cnt == 0:
    print(-1)
else:
    print(cnt)
