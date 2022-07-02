# 2022.07.02.

## 방문 길이

[방문 길이](https://programmers.co.kr/learn/courses/30/lessons/49994)

### 풀려고 한 방식

리스트로 경로를 표현하려 했다.

[x, y] 만으로는 경로를 표시 못한다.

하나의 값이 가로 세로 이렇게 두 개씩 존재 한다.

시간이 다 돼서 찾아 보니 더 나은 방법이 있었다.

### 다른 사람 코드

set, dict 를 이용해 경로를 저장한다.

(출발x, 출발y, 도착x, 도착y)

저장할 때 범위를 확인해 주고

출발과 도착 중 작은 값이 앞에 오도록 저장해 어떻게 상하, 좌우 어떤 방식으로 이동하던 동일한 값으로 처리한다.

그리고 set, dict 은 중복을 허용하지 않기에 따로 중복 확인을 할 필요 없다.

* 추가 순서 주의

```
x -= 1
visited[(x-1, y, x, y)] = True
```

이게 아니라 추가하고 변경 해줘야 함

현재 위치를 기준으로 저장 한 것이 아니라 다음 위치를 기준으로 저장한거기 때문에 아래처럼 해야함

```
visited[(x-1, y, x, y)] = True
x -= 1
```

* Reference

https://intrepidgeeks.com/tutorial/python-programmer-access-length