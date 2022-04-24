def binary_search(array, target, start, end):
    if start > end:
        return -1
    mid = (start + end) // 2
    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    elif array[mid] < target:
        return binary_search(array, target, mid + 1, end)


array = [1, 2, 3, 4, 5, 6, 7, 8, 9]
x = 6

print(binary_search(array, x, 0, len(array) - 1))
