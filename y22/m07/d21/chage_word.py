def solution(begin, target, words):
    answer = 0

    if target not in words:
        return 0

    q = []
    q.append((begin, 0))
    while q:
        print(q)
        pop_word, cnt = q.pop(0)
        if pop_word == target:
            answer = cnt
            break
        for word in words:
            if can_change_word(pop_word, word):
                q.append((word, cnt + 1))

    return answer


def can_change_word(pop_word, word):
    diff_cnt = 0
    for i in range(len(pop_word)):
        if pop_word[i] != word[i]:
            diff_cnt += 1
    if diff_cnt == 1:
        return True
    return False


print(solution('hit', 'cog', ["hot", "dot", "dog", "lot", "log"]))
