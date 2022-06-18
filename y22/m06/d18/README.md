# 2022.06.18.

# 자연수 뒤집어 배열로 만들기

[자연수 뒤집어 배열로 만들기](https://programmers.co.kr/learn/courses/30/lessons/12932)

## 내 풀이

```
def solution(n):
    answer = []
    n_str = str(n)
    for i in range(len(n_str)):
        answer.append(int(n_str[len(n_str) - i - 1]))
    return answer
```

## 다른 사람 풀이

```
def solution(n):
    return list(map(int, reversed(str(n))))
```

# 완주 하지 못한 선수

[완주하지 못한 선수](https://programmers.co.kr/learn/courses/30/lessons/42576?language=python3)

## 내 풀이

```
def solution(participant, completion):
    for participantName in participant:
        if participantName not in completion:
            return participantName
        else:
            completion.remove(participantName)
    return completion[0]
```

1. 참가자 목록 반복
    1. 완주자 목록 반복해 존재 여부 확인
    2. 존재하지 않을 경우 현재 참가자가 완주하지 못한 사람
    3. 존재할 경우 완주자 목록에서 삭제 후 다음 반복으로
    4. 끝까지 반복 할 경우 마지막 남은 참가자가 완주하지 못한 사람

효율성 실패 for for 로 시간 복잡도 O(n^2)

completion 에 어떻게 완주하지 못한 참가자 이름이 있지? 왜 맞았지?

## 정답

### 단순 풀이

1. 두 배열 정렬
2. 완주자 수 만큼 반복
    1. 다른 값이 나오면 현재 참가자가 완주하지 못한 참가자
    2. 끝까지 없다면 마지막 참가자가 완주하지 못한 참가자

힙 정렬 한다고 치면 nlogn * 2 + n -> 시간 복잡도 n

### 해시

1. key : 참가 선수 이름, value : 참가 선수 이름으로 완주한 사람 수

2. 참가한 선수를 반복해 가며 위 처럼 추가

3. 완주 한 선수를 반복해 가며 값 -1

4. value 가 1 인 선수가 완주 하지 못한 선수

n + n + n -> 시간 복잡도 n

```
def solution(participant, completion):
    result = dict.fromkeys(participant, 0)
    for key in participant:
        result[key] += 1
    
    for key in completion:
        result[key] -= 1

    for key in result:
        if result[key] != 0:
            return key
```

## 느낀점

아직 초반이라 많은 유형 풀어보게 안 되겠으면 해설을 보자

해시 유형은 처음 들어봤다.

프로그래머스 스킬체크 1단계 통과 못하는게 빡치긴 하지만

그게 지금 나니까 어쩔 수 없다. 그래도 계속 해야지.

자바로 하겠다는건 고집인가...

확실히 도움은 될 것 같은데 자바 + 코테 한번에 두개 하는 느낌이다.

코테 파이썬으로 하고 푼 걸 자바로 바꿔보자

## Reference

[시간 복잡도](https://blog.chulgil.me/algorithm/)

[완주하지 못한 선수 풀이](https://coding-grandpa.tistory.com/entry/프로그래머스-완주하지-못한-선수-해시-Lv-1)

