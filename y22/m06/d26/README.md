# 2022.06.26.

# 이진 변환 반복하기

[이진 변환 반복하기](https://programmers.co.kr/learn/courses/30/lessons/70129)

## 원소의 개수

for 문으로 개수 세고 있었는데

```
num = s.count('1')
```

가 있구나

## 이진법 변환

```
s = format(oriLength, 'b')
s = bin(num)[2:]
```

함수 만들까 하다가 검색해서 했는데 확실히 편하다.

하다 보면 안 찾아 보고도 기억 나겠지

# 후보키

[후보키](https://programmers.co.kr/learn/courses/30/lessons/42890)

유일성을 먼저 구하고 최소성을 만족하는지 구하면 됨.

set : {}
tuple : ()
list : []

list 로 비교하고 있었다. 애초에 set 이 집합이라는 뜻이구나..

## 부분 집합 확인 하는 방법

```
{0, 1} <= { 0, 1, 2 } # True

{0, 1}.issubset({0, 1, 2}) # True
```

## 기타

좋은 코드 있나 확인 하려다가 내가 몰랐던 부분 정리된 블로그 찾았다.

append : 리스트에 요소 추가

extend : 리스트 확장 (지금 까지 list_a += list_b 로 사용 했던 것)

https://velog.io/@sem/프로그래머스-LEVEL2-후보키-Python

# 소감

통과 할 뻔 했는데 아깝다.

근데 할 수록 이런 것도 있구나 싶어서 재밌다.
