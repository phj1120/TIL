def solution(s):
    answer = ''
    lowerS = s.lower()

    answer += s[0].upper()
    for i in range(1, len(lowerS)):
        if lowerS[i - 1] == ' ':
            answer += lowerS[i].upper()
        else:
            answer += lowerS[i]
    return answer


def best_solution(s):
    s = s.split(" ")
    for i in range(len(s)):
        s[i] = s[i][:1].upper() + s[i][1:].lower()
    return ' '.join(s)


s = ''
print('s : |' + s[0] + '|')  # 에러 발생
print('s : |' + s[:1] + '|')
