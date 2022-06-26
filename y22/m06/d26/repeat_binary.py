def solution(s):
    repeatCnt = 0
    totalZeroCnt = 0
    while s != '1':
        zeroCnt = 0
        for ch in s:
            if ch == '0':
                zeroCnt += 1
        oriLength = len(s) - zeroCnt
        s = format(oriLength, 'b')
        totalZeroCnt += zeroCnt
        repeatCnt += 1
    return [repeatCnt, totalZeroCnt]


def best_solution(s):
    a, b = 0, 0
    while s != '1':
        a += 1
        num = s.count('1')
        b += len(s) - num
        s = bin(num)[2:]
    return [a, b]
