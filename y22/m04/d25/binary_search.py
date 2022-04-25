array = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]


def binary_search(array, target, start, end):
    mid = (start + end) // 2

    if start > end:
        return -1

    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    elif array[mid] < target:
        return binary_search(array, target, mid + 1, end)


print(binary_search(array, 4, 0, len(array) - 1))
