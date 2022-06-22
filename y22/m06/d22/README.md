# 2022.06.22.

# 모음 사전

[모음 사전](https://programmers.co.kr/learn/courses/30/lessons/84512)

아이디어 떠롤리고 순열, 중복순열 어떻게 쓰는지 검색해서 itertools 사용해 봤다.

```
tuples = list(itertools.product(dictionary, repeat=i))
for tuple in tuples:
    str = ''.join(tuple)  # tuple to str
    result.append(str)
```

```
result += list(map(''.join, itertools.product(dictionary, repeat=i)))
```

간단하고 더 빠름

이건 python map 사용법 찾아 봐야 할 듯

# 프렌즈4블록

될 것 같은데 왜 안되지? 하면서 근성으로 풀었다

재 탐색시 공백 값을 제외 안 해줘서 무한 루프를 돌았고,

그거 테스트 한다고 cnt <10 break 넣었다가

공백 제거 수정하고 break 를 삭제 안해 그 이상 깊이로 못 들어가 실패했다.

단순 구현이었는데... 진짜 오래 걸렸다.

[프렌즈4블록](https://programmers.co.kr/learn/courses/30/lessons/17679)

