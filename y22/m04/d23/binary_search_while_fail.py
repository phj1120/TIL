# # 처음 구현
# # 문제점 제대로 된 index 를 구할 수 없음
# # 시작과 끝을 두고 구해야 할 듯
#
# array = [1, 2, 3, 4, 5, 6, 7, 8, 9]
# x = 6
#
# while len(array) > 1:
#     m = len(array) // 2
#     if array[m] == x:
#         print("array[", m, "] =", array[m])
#         break
#     elif array[m] > x:
#         array = array[:m]
#     elif array[m] < x:
#         array = array[m:]
#
# print(m)
#
# # 종료조건을 모르겠네
# array = [1, 2, 3, 4, 5, 6, 7, 8, 9]
# l = 0
# r = len(array) - 1
# m = (l + r) // 2
# x = 6
#
# while len(array) > 1:
#     if array[m] == x:
#         print("array[", m, "] =", array[m])
#         break
#     elif array[m] > x:
#         r = m - 1
#         m = r // 2
#     elif array[m] < x:
#         l = m + 1
#         m += r // 2


array = [1, 2, 3, 4, 5, 6, 7, 8, 10]
start = 0
end = len(array) - 1
target = 9

while start <= end:  # 배열에 없으면 역전 현상 발생 ( 배열이 한 개가 되고 end = mid - 1 or start = mid + 1 가 수행 되기 때문에)
    mid = (start + end) // 2  # 이러면 위치 상관 없이 중간 값 찾을 수 있구나
    if array[mid] == target:
        break
    if array[mid] > target:
        end = mid - 1
    if array[mid] < target:
        start = mid + 1
    print(start, end)
    mid = None

print(mid)

# 로직은 동일한데 왜 안 됐는지 분석
array = [1, 2, 3, 4, 5, 6, 7, 8, 9]
l = 0
r = len(array) - 1
m = (l + r) // 2
x = 6

while len(array) > 1:
    if array[m] == x:
        print("array[", m, "] =", array[m])
        break
    elif array[m] > x:
        r = m - 1
        m = r // 2
    elif array[m] < x:
        l = m + 1
        m += r // 2
