import heapq


# 최소 힙, 오름 차순 정렬(heap sort)
def asc_heapsort(iterable):
    h = []
    result = []

    for value in iterable:
        heapq.heappush(h, value)

    for i in range(len(h)):
        result.append(heapq.heappop(h))

    return result


# 최대 힙, 내림 차순 정렬(heap sort)
def desc_heapsort(iterable):
    h = []
    result = []

    for value in iterable:
        heapq.heappush(h, -value)

    for i in range(len(h)):
        result.append(-heapq.heappop(h))

    return result


result = asc_heapsort([1, 3, 5, 6, 7, 4, 9, 8, 0])
print(result)

result = desc_heapsort([1, 3, 5, 6, 7, 4, 9, 8, 0])
print(result)
