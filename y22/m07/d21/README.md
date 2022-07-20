# 2022.07.21.

## 단어 변환

[단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163)

생각 보다 괜찮게 풀렸다.

```
if target not in words:
    return 0
```

가 없어도 동작하기는 해야되는데 왜 안되는지 까봐야겠다.

종료 조건이 target == word 라 종료가 안됐음.

그래서 위와 같은 코드 넣어 줘야함.
