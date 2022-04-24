input()
stock_array = list(map(int, input().split(' ')))
input()
request_array = list(map(int, input().split(' ')))


def binary_search(array, target, start, end):
    mid = (start + end) // 2
    if start > end:
        return "no"
    if array[mid] == target:
        return "yes"
    if array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    if array[mid] < target:
        return binary_search(array, target, mid + 1, end)


stock_array.sort()
for request in request_array:
    print(binary_search(stock_array, request, 0, len(stock_array) - 1), end=" ")
