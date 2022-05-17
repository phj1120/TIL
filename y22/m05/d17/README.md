# 2022.05.17.

## 다른 사람 코드와 비교

[카카오 프렌즈 컬러링북](https://programmers.co.kr/learn/courses/30/lessons/1829)

* 최예소라

```
    } // end of for_k
  } // end of while
```

이렇게 표시해주는게 코드가 길어 보일 수 는 있지만 확실하긴 표시 되기는 하네

괄호 사이에 문장이 길면 적어둬도 괜찮을 듯.

나는 가로, 세로 크기 m, n 을 static 으로 선언 후 this.m = m 이런 식으로 사용.

```
m = picture.length 
n = picture.length[i]
```

이 분 처럼 이렇게 했어도 됐겠다.

코드를 잘 읽히게 짜셨다.

# Static 변수

나는 static 변수를 사용했는데 이거가 안 좋은 습관인가? 

검색

지향해야 하는 습관이다.

1. 프로그램의 상태를 추정하기 어렵게 만듦
2. static은 객체 지향적이지 않음

[관련 글](https://unabated.tistory.com/entry/왜-자바에서-static의-사용을-지양해야-하는가)
