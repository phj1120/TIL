# 2022.12.19.

# 155. Min Stack

[155. Min Stack](https://leetcode.com/problems/min-stack/description/)

그냥 기본 스택에, min 구하는 메서드를 추가하는 식으로 구현했다.

뭘 원하는 거지..? 싶기도 하고, 시간이나 메모리를 많이 써서 다른 분들 풀이를 봤다.

키워드는 min 값 관리를 어떻게 할 지 였다.

스택을 두 개 둬 정상적인 값, 작은 값 동시에 관리 하는 방법이 가장 간단했고,

Node 클래스를 만드는 방법이 가장 깔끔했다.

Node 클래스에 min, 다음 노드를 저장하고,

pop, push 를 할때마다 head 를 변경해줘 연결 되도록 했다.
