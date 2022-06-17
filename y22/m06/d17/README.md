# 2022.06.17.

# 핸드폰 번호 가리기

[핸드폰 번호 가리기](https://programmers.co.kr/learn/courses/30/lessons/12948?language=java)

python 은

```
'*' * (len(phone_number) - 4) + phone_number[-4:]
```

이렇게 하면 되는데 Java 는 이거 안되나? 라는 생각 하면서 그냥 subString 풀었다.

```
String answer = "";
int length = phone_number.length();
for (int i = 0; i < length - 4; i++) {
    answer += "*";
}
answer += phone_number.substring(length - 4, length);
```

다른 사람들 코드 보니까 자바는 파이썬 처럼은 안되나 보다.

```
char[] number = phone_number.toCharArray();

for (int i = 0; i < number.length - 4; i++) {
    number[i] = '*';
}

return String.valueOf(number);
```

확실히 시간도 빠르고 더 괜찮은 듯.

Arrays.toString 은 괄호, 콤마 까지 다 문자열로 바꿔 준다.

# 문자열 내 마음대로 정렬하기

[문자열 내 마음대로 정렬하기](https://programmers.co.kr/learn/courses/30/lessons/12915)

python 은 문자열도 > 로 비교할 수 있는데 java 는 안되는구나..

Comparator 봐야겠다.

[참고](https://st-lab.tistory.com/112)

# 느낀점

내가 정렬을 못 푸나? 했는데 생각 해보니까

전에 구현 한 두번 해본게 끝이었다.

기초도 안 쌓고 응용 문제를 풀려고 했네...

프로그래머스 스킬 체크 하면서 공부 해야 겠다.

나한테 안 맞는 거 붙잡고 있지 말고 그냥 하려고 한다.
