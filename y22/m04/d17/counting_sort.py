# 계수 정렬 (counting_sort) 구현

# 직접 구현
array = [5, 7, 4, 7, 8, 9, 5, 2, 2, 3, 1, 9, 0, 3, 1, 6, 2, 4, 8]
cnt_array = [0 for x in range(max(array) + 1)]

for x in array:
    cnt_array[x] += 1

array_str = ""
for idx, x in enumerate(cnt_array):
    for i in range(x):
        array_str += str(idx) + " "

print("my ", array_str)

# 이코테 Sol
array = [5, 7, 4, 7, 8, 9, 5, 2, 2, 3, 1, 9, 0, 3, 1, 6, 2, 4, 8]
cnt_array = [0] * (max(array) + 1)

for i in range(len(array)):
    cnt_array[array[i]] += 1

print("sol", end=' ')
for i in range(len(cnt_array)):
    for j in range(cnt_array[i]):
        print(i, end=' ')
