import itertools


def solution(word):
    vowel = ['A', 'E', 'I', 'O', 'U']

    dictionary = vowel[:]
    for i in range(2, 6):
        tuples = list(itertools.product(vowel, repeat=i))
        for tuple in tuples:
            str = ''.join(tuple)  # tuple to str
            dictionary.append(str)
    dictionary.sort()

    return dictionary.index(word) + 1


# 속도 2배 정도 빠름
def best_solution(word):
    dictionary = 'AEIOU'
    result = []
    for i in range(1, 6):
        result += list(map(''.join, itertools.product(dictionary, repeat=i)))

    result.sort()
    return result.index(word) + 1


# 합해도 느림
def mix_solution(word):
    dictionary = 'AEIOU'
    result = ['A','E','I','O','U']
    for i in range(2, 6):
        tuples = list(itertools.product(dictionary, repeat=i))
        print(tuples)
        for tuple in tuples:
            str = ''.join(tuple)  # tuple to str
            result.append(str)
    result.sort()

    return result.index(word) + 1