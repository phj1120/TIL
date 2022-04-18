# 선택 정렬
# 전체 정렬에서 가장 작은 값을 선택해 맨 앞과 자리 변경
# 그 다음 작은 값을 선택해 그 앞과 자리 변경 -> 반복

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_idx = i
    for j in range(i + 1, len(array)):
        if array[min_idx] > array[j]:
            min_idx = j
    array[min_idx], array[i] = array[i], array[min_idx]

print(array)

# 삽입 정렬
# 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입
# 처리된 데이터의 맨 뒤에서 부터 작을 경우 자리 변경 반복
# 이 과정 반복

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)):
    for j in range(i, 0, -1):
        if array[j - 1] > array[j]:
            array[j - 1], array[j] = array[j], array[j - 1]
        else:
            break
print(array)

# 퀵 정렬
# 왼쪽에서 부터 array[pivot] 보다 큰 수(array[left] 찾음
# 오른쪽에서 부터 array[pivot] 보다 작은 수(array[right]) 찾음
# left > right (교차될 경우) array[pivot] 과 array[right] 위치 변경
# left <= right 일 경우 array[right] 와 array[left] 위치 변경
# 이를 재귀적으로 호출

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort(array, start, end):
    if start >= end:
        return

    pivot = start
    left = start + 1
    right = end
    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left > right:
            array[right], array[pivot] = array[pivot], array[right]
        else:
            array[left], array[right] = array[right], array[left],

    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)


quick_sort(array, 0, len(array) - 1)
print(array)

# 퀵 정렬 - 리스트 컴프리헨션
# pivot 값을 정해 이 값을 기준으로 작으면 왼쪽 크면 오른쪽
# 나눠진 값에서 다시 pivot 을 정해 재정렬
# 이를 재귀적으로 호출


array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort_list_comprehension(array):
    if len(array) <= 1:
        return array
    pivot = array[0]
    tail = array[1:]
    left_array = [x for x in tail if x <= pivot]
    right_array = [x for x in tail if x > pivot]
    return quick_sort_list_comprehension(left_array) + [pivot] + quick_sort_list_comprehension(right_array)


print(quick_sort_list_comprehension(array))

# 계수 정렬
