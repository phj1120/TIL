# 2022.05.09.

# 문자열 압축

Best 코드와 비교

랜덤여신 , Yang Sang-Ho , - , david 님들이 짠 코드는 

이렇게도 되는구나 감탄은 했지만 내 기준엔 어려웠다.

나른해 님이 짠 코드는 이해가 되서 읽어보고 내 코드랑 비교해 봤다.

* 함수 사용

함수로 따로 만들어서

    answer = len(s)
    answer = min(answer, compare())

이렇게 하니까

내가 한 것 처럼

    if len(s) == null
    return 1

할 필요도 없고 이해가 더 쉬워 좋았음

* 중복 개수 확인

중복 개수 확인도 나는 반복 할 때마다 전에 값을 공백과 숫자로 바꿨다.

    ["abc", "abc", "abc"] -> ["2", "abc", "abc"] -> ["", "3", "abc"]

여기선 while 로 중복개수 카운트하고 ans 라는 문자열을 따로 만들어

반복하는 하면 cnt++ 하고 아닐 경우 answer 에 추가

    if cnt>1:
        ans += target 
    else:
        ans += cnt + target

가독성도 그렇고 더 효율적인 것 같음

* 변수 선언 및 대입

한 줄씩 하는 것보다 한 줄에 하니까 코드가 덜 더러워 보였다

    target,s,cnt = s[:length], s[length:],1

