def solution(scoville, K):
    import heapq

    heap = []
    for num in scoville:
        heapq.heappush(heap, num)

    cnt = 0
    while heap[0] < K:
        if heap[0] >= K:
            break
        if len(heap) == 1 and heap[0] < K:
            cnt = -1
            break
        cnt += 1
        first_not_spicy_scoville = heapq.heappop(heap)
        second_not_spicy_scoville = heapq.heappop(heap)
        mix_scoville = first_not_spicy_scoville + (2 * second_not_spicy_scoville)
        heapq.heappush(heap, mix_scoville)
    return cnt
