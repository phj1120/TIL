# 2022.04.17.

# [리스트 컴프리헨션](https://wikidocs.net/22805)

리스트 내부에 코드를 작성해 리스트 초기화

기존

    numbers = []
    for n in range(1, 10+1):
        numbers.append(n)

리스트 컴프리헨션

    [x for x in range(10)]

if 문 키워드 지원

    left_side =[]
    for x in tail:
        if x <= pivot:
            left_side.append(x)
    

    left_side = [x for x in tail if x <= pivot]

# 리스트 컴프리헨션 - 퀵 정렬

    def quick_sort(array):
        if len(array) <= 1:
            return array
        pivot = array[0]
        tail = array[1:]
    
        left_side = [x for x in tail if x <= pivot]
        right_side = [x for x in tail if x > pivot]
    
        return quick_sort(left_side) + [pivot] + quick_sort(right_side)

# 계수 정렬

데이터의 크기 범위가 제한 되어 정수 형태로 표현 될 수 있을때만 사용 가능한 매우 빠른 정렬 방법

데이터 범위 만큼의 크기를 갖는 리스트 생성

데이터를 하나씩 확인하며 데이터의 값과 동일한 인덱스의 데이터를 1씩 증가시킴

리스트의 첫 번째 부터 하나씩 그 값 만큼 반복하며 인덱스 출력

O(N+K)

( 0 , 999,999 ) 를 정렬할 경우는 심각한 비효율 초래

동일한 값을 가지는 데이터가 여러개 등장할 때 효과적으로 사용 가능

ex 학생을 성적에 따라 정렬할 경우

미쳤다. 이런 아이디어는 누가 내는거야

# 정렬 알고리즘 비교

![](정렬%20알고리즘%20비교.png)

# 두 배열의 원소 교체 문제

    n, k = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

값 받아오는게 혁명이다..


## 내일
[이진 탐색](https://www.youtube.com/watch?v=94RC-DsGMLo&list=PLRx0vPvlEmdAghTr5mXQxGpHjWqSz0dgC&index=5) 
