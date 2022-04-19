import bisect

n, m = map(int, input().split(' '))
array = list(map(int, input().split(' ')))

h = max(array)
array.sort()

while True:
    sum_dduk = 0
    over_h = bisect.bisect_left(array, h)  # 자르려는 길이보다 큰 배열의 시작 부분 인덱스
    for i in array[over_h:]:
        sum_dduk += (i - h)  # 자르려는 길이보다 큰 부분의 합
    if sum_dduk >= m:
        break
    h -= 1
print(h)
