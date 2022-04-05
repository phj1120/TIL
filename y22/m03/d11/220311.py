# 11719
# ?
# 11719 랑 다를게 없는데 의도가 뭐지
# 음.. 입력 조건 차인데
# 입력 조건은 넘겨도 될 줄 알았는데 입력 조건도 고려하자.

# 1
# while True:
#     try:
#        print(input())
#     except EOFError:
#         break
#
# 2번
# cnt = 0
# while cnt<=100:
#     try:
#         str = input()
#         if len(str) > 100:
#             str = str[:101]
#
#         print(str)
#         cnt += 1
#     except EOFError:
#         break

# 순위권 코드
# import sys
# print(sys.stdin.read())
#
# import sys
# for i in sys.stdin:
#     print(i, end="")

# 이게 맞는건가 모르겠다.


# 11718
# 입력 받은 대로 출력하는 프로그램을 작성하시오.
# 입력에 적혀 있는게 문제의 조건 X
# 입력 되는 값이 저런 식으로 되어 있다. 정도
# 입력 조건에 대한 오류 처리는 여기서는 다루는 것이 아닌듯?

# 풀이 1
# strs = []
#
# while True:
#     try:
#         str = input()
#         if(str == ''):
#             break
#         if(len(str)>100):
#             str = str[:101]
#         str = str.strip()
#         strs.append(str)
#     except:
#         break
#
# for str in strs:
#     print(str)
# 풀이 2
# while True:
#     try:
#         print(input())
#     except EOFError:
#         break

# 11720
# 풀이 1
# cnt = int(input())
# numbers = input()
# sum = 0
#
# try:
#     for i in range(cnt):
#         sum += int(numbers[i])
#     print(sum)
# except Exception as e:
#     print(e)

# # Rank 1
# input()
# a = 0
# for i in input():
# 	a += int(i)
# print(a)

# Rank 2
# n = int(input())
# arr = map(int, list(input()))
# print(sum(arr))