# input()
# stock_array = list(map(int, input().split(' ')))
# input()
# request_array = list(map(int, input().split(' ')))

print('계수 정렬')
stock_array = [8, 3, 7, 9, 2]
request_array = [4, 7, 9]

array = [0] * 1000001

for i in stock_array:
    array[i] = 1

for i in request_array:
    if array[i] == 1:
        print('yes', end=' ')
    else:
        print('no', end=' ')

print('\n집합 자료형')
for i in request_array:
    if i in stock_array:
        print('yes', end=' ')
    else:
        print('no', end=' ')
