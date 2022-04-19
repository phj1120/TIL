# n : 떡의 개수 / m : 떡의 길이
n, m = map(int, input().split(' '))
# 각 떡의 개별 높이
array = list(map(int, input().split(' ')))

# 시작과 끝 설정
start = 0
end = max(array)

# 이진 탐색 수행
result = 0
while start <= end:
    total = 0
    mid = (start + end) // 2
    for x in array:
        if x > mid:
            total += x - mid
    if total < m:
        end = mid - 1
    else:
        result = mid
        start = mid + 1
print(result)
print(array)
print(total)


"""
4 8
13 12 14 11
"""
