# 2022.06.23.

## 캐시

[캐시](https://programmers.co.kr/learn/courses/30/lessons/17680)

어렵지 않게 금방 풀었다.

* 개선한 것

최대 길이를 지정해 줌으로 범위에 대해 고려할 필요가 없어짐 (삭제 및 재정렬)

```
cache = collections.deque(maxlen=cacheSize)
```

## 프린터

[프린터](https://programmers.co.kr/learn/courses/30/lessons/42587)

이상한 방향으로 생각 안하고 논리적으로 생각했다면 더 빨리 풀었다면 통과 했을 수 도 있었는데 아깝다

근데 그러면 바로 레벨 3라 레벨 2에서 기본 쌓는게 지금은 오히려 좋을 수도?

* 개선한 것

python 의 list 에 pop 연산이 있는 줄 모르고 리스트 슬라이싱으로 범위를 다시 지정해 줬다.

```
now_docs = priorities.pop(0)
```
