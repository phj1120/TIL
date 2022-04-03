# 2022.04.03.

## 자료구조 - 미로 탐색 프로그램

어떤 로직인지 알겠는데

static 으로 선언하고 해야되나?

클래스를 만들어야 되나?

어떻게 구현 해야할지 감이 안 잡힘

일단 책대로 해보고 이해하기


## Q2941
크로아티아 알파벳

문자열에 있는 특정 문자 검색

String 
boolean	contains(CharSequence s)

대상 문자열에서 찾고자하는 문자열이 포함되어 있는지 여부

int	indexOf(int ch str)

대상 문자열에서 찾고자하는 ~의 index 값


* 문제 풀이 아이디어

처음엔 주어진 값으로 split 후 개수를 세서 cnt 에 더함

다시 문자열로 합치고 String.join("", str)

될 때 까지 반복 이렇게 했다.

비효율적인 것을 알면서도 다른 아이디어가 마땅히 떠오르지 않아 계속 해봤다.

ddz=z= 의 경우, 마지막에 나눌 값이 오는 경우 등등 예외 케이스가 나와서 다시 생각

치환하면 되겠다 싶어서 치환 했더니 간단하게 풀림



## 내일 할 것 

DFS & BFS

https://www.youtube.com/watch?v=7C9RgOcvkvo&list=PLRx0vPvlEmdAghTr5mXQxGpHjWqSz0dgC&index=3

미로 탐색 문제(Q2178)

