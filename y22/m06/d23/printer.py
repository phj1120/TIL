def solution(priorities, location):
    cnt = 0
    while True:
        print_state = True
        now_docs = priorities.pop(0)
        location -= 1

        for priority in priorities:
            if now_docs < priority:
                print_state = False
                break

        # print(priorities)
        if print_state:
            cnt += 1
            if location == -1:
                break
        else:
            priorities.append(now_docs)

            if location == -1:
                location = len(priorities) - 1
    return cnt


def best_solution(priorities, location):
    queue = [(i, p) for i, p in enumerate(priorities)]
    answer = 0
    while True:
        cur = queue.pop(0)
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            answer += 1
            if cur[0] == location:
                return answer
