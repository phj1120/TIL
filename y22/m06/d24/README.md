# 2022.06.24.

## 수식 최대화

[수식 최대화](https://programmers.co.kr/learn/courses/30/lessons/67257)

연산자와 숫자 같이 배열에 담는 방법

```
import re
expression_list = re.split('[*+-]', expression)
```

```
expression = expression.replace('+', ' + ').replace('-', ' - ').replace('*', ' * ')
expression_list = expression.split(' ')
```

idx 가 줄어야할 떄 for 를 쓰기보단 while 을 쓰는게 나으려나

for 로 하니까 list 에서 remove 할 때 범위가 좁아져서 원하는 대로 안 됨

여기서 시간 엄청 보냈다.

## 삼각 달팽이

[삼각 달팽이](https://programmers.co.kr/learn/courses/30/lessons/68645)

## 소감

오늘은 한 문제도 못 풀었다...

내일 다시 풀어야 겠다.