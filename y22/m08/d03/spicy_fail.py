def solution(scoville, K):
    cnt = 0
    while True:
        scoville.sort()
        if scoville[0] >= K:
            break
        if len(scoville) == 1 and scoville[0] < K:
            cnt = -1
            break
        cnt += 1
        first_not_spicy_scoville = scoville.pop(0)
        second_not_spicy_scoville = scoville.pop(0)
        mix_scoville = first_not_spicy_scoville + (2 * second_not_spicy_scoville)
        scoville.append(mix_scoville)
    return cnt
