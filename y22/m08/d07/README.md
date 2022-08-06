# 2022.08.07.

## 피로도

[피로도](https://school.programmers.co.kr/learn/courses/30/lessons/87946)

```
routes = []
for i in range(1, len(dungeons) + 1):
    for route in list(permutations(dungeons, i)):
        routes.append(route)
```

모든 경로를 방문하기 위해 이런식으로 했는데

```
permutations(dungeons, len(dungeons))
```

이런식으로만 하고 중간에 만족 못하면 클리어 한 곳까지 개수 세고 건너뛰면 됐다.

