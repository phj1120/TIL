# 2022.10.03.

## 특정 거리의 도시 찾기(Q18352)

[특정 거리의 도시 찾기](https://www.acmicpc.net/problem/18352)

분석해보고 어떻게 풀어야하나 정리해 봤다.

당분간 TIL 은 BFS 위주로 한번 파봐야겠다.

## 요약

최종 코드 : Q18352Final

* Getter/Setter 를 사용한다고 유의미한 시간 차이는 없었음

  -> Getter/Setter 쓰자


* BufferedReader 와 Scanner 는 유의미한 시간 차이가 있었음

  -> BufferedReader 쓰자


* BufferedWriter 와 Sout 은 시간차이가 났지만 그리 크지 않았음

  -> 알아서 쓰자(그래도 여유 되면 BufferedWriter...)


* 배열을 선언하고 사용하는게 시간이 더 오래걸리지만, 그리 큰 차이는 나지 않았음

  -> 남용은 안되겠지만 걱정 없이 쓰자.


* BFS
    * Queue 에 현재 노드에서 방문할 수 있는 노드를 방문한 적 없는 노드를 넣는다.
    * 현재 노드에서 방문할 수 있는 모든 노드를 넣고, 꺼내서 방문한적 있는지 확인하는 것이 아니다.
