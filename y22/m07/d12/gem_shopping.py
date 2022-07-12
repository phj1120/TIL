def solution(gems):
    size = len(set(gems))
    dic = {gems[0]: 1}
    answer = [0, len(gems) - 1]
    start, end = 0, 0

    while start < len(gems) and end < len(gems):
        if len(dic) == size:
            if end - start < answer[1] - answer[0]:
                answer = [start, end]
            if dic[gems[start]] == 1:
                dic.pop(gems[start])
                # del dic[gems[start]]
            else:
                dic[gems[start]] -= 1
            start += 1

        else:
            end += 1
            if end == len(gems):
                break
            if gems[end] in dic.keys():
                dic[gems[end]] += 1
            else:
                dic[gems[end]] = 1

    return [answer[0] + 1, answer[1] + 1]
