# 2022.06.25.

## 수식 최대화

[수식 최대화](https://programmers.co.kr/learn/courses/30/lessons/67257)

while 로 바꾸고 테스트 케이스 통과

근데 왜 안되지였는데

최대 값을 구하는 위치를 for 하나 바깥으로 빼고 성공 했음.

python3 에 long 이 없다는 거 새로 알았다.

[java](https://jangcenter.tistory.com/114)

[카카오 해설](https://tech.kakao.com/2020/07/01/2020-internship-test/)

나는 숫자와 연산자를 하나의 배열에 두고 계산 했지만

숫자와 연산자를 구분해 다른 배열에 두고 푸는 것도 괜찮은 방법인 것 같다.

## 삼각 달팽이

[삼각 달팽이](https://programmers.co.kr/learn/courses/30/lessons/68645)

아이디어까지는 생각했다. 근데 이걸 구현할 엄두가 안나서 정답을 봤다.

한 배열에 인덱스 별로 구분 해야되나...

2차원 배열에 담고, 

현재 위치 (x, y) 에 값을 넣고

현재 진행 중인 방향으로 이동 시켜주면 된다.

근데 마지막 보니까 시간이 엄청 걸린 거로 보아 효율성은 별로인듯 코드 참고해야겠다.

다른 사람들이 짠 코드를 봐도 다 비슷하다. 오히려 효율적인 편에 속하는듯

다른 방법과 비교

* 2차원 -> 1차원 
```
for arr in arrs:
    answer += arr

return answer
```

```
sum(arrs, [])
```

같은 결과를 내지만 위에가 훨씬 빠르다

* 리스트 컴프리헨션
```
arrs = []
for i in range(1, n + 1):
arrs.append([0] * i)
```

```
[[0]*i for i in range(1,n+1)]
```

나한테 익숙하지는 않으나 훨씬 간결하긴 하다.