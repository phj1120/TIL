# 2022.07.11.

# 보석 쇼핑

[보석 쇼핑](https://school.programmers.co.kr/learn/courses/30/lessons/67258#)

# 투 포인터 알고리즘

1차원 배열에 두 개의 포인터를 둬 리스트의 특정 범위 내에서 원하는 결과를 얻어내는 방법.

시간 복잡도 O(N)

* 참고 자료
  https://m.blog.naver.com/kks227/220795165570)

# 관련 문제 - 수들의 합2

[백준 2003](https://www.acmicpc.net/problem/2003)

```
while s < n - 1 and e < n - 1:
    if sum < m:
        e += 1
        sum += A[e]
    elif sum > m:
        sum -= A[s]
        s += 1
    if sum == m:
        correct_cnt += 1
        sum -= A[s]
        s += 1

if A[-1] == m:
    correct_cnt += 1
```

1차원 배열에서 합이 m 인 배열 개수를 구하는 문제

시작(s), 끝(e) 포인터를 둬 원하는 값을 얻는다.

이 경우 마지막 인덱스만은 고려하지 않아 if 문 추가.
