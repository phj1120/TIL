def solution(s):
    numbers = ['zero', 'one', 'two', 'three', 'four', 'five',
               'six', 'seven', 'eight', 'nine']
    for idx, number in enumerate(numbers):
        s = s.replace(number, str(idx))

    return int(s)
