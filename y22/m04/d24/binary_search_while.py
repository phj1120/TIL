def binary_search(array, target):
    start = 0
    end = len(array) - 1

    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        if array[mid] > target:
            end = mid - 1
        if array[mid] < target:
            start = mid + 1
    return None


array = [1, 2, 3, 4, 5, 6, 7, 8, 9]
x = 6

print(binary_search(array, x))
