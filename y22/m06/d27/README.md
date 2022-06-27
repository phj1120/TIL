# 2022.06.27.

## 양궁대회

[양궁대회](https://programmers.co.kr/learn/courses/30/lessons/92342)

124 나라는 전에 풀었던거라 양궁 대회 먼저 풀었는데 이거 풀다가 시간 다 보냈다.

조건 충족하게 유사 코드로 짜고 딱 구현하려고 했는데

B 의 모든 기록을 구할 방법에서 막혔다.

bfs, dfs 로 다 구하면 될 것 같은데 어떻게 하더라에서 막혔다.

내일은 bfs, dfs 보고 답 보고 이해 해야겠다.

## 124 나라의 숫자

[124 나라의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12899?language=python3#)

* 종료 조건

AS-IS

```
if quotient < 3:
    if quotient == 0:
        return str(remainder)
    else:
        return str(quotient) + str(remainder)
```

TO-BE

```
if n <= 3:
    return str(remainder)
```

* 몫, 나머지

AS-IS

```

quotient = n // 3
remainder = n % 3

```

TO-BE

```
quotient, remainder = divmod(n, 3)
```

풀었던 문제지만 그렇게 쉽게 풀리진 않았음
