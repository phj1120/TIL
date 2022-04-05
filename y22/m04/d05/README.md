# 2022.04.05.

## 오늘 할 것
1. DFS 스택으로 구현.
2. BFS 개념 및 구현 다시.

## DFS
깊이 우선 탐색

갈 수 있는 깊은 곳까지 가고 

이전으로 돌아오고 다시 갈 수 있는 곳까지 가고 반복


스택, 반복문 대신 재귀를 쓰는 건데

재귀랑 스택을 같이 써서 이상한 코드가 됐다.

```
static public int dfs(int p) {
    isCheck.set(p, true);
    System.out.println(p +" ");
    for (int i = g.get(p).size() -1 ; i >= 0; i--) {
        int y = g.get(p).get(i);
        System.out.println("isCheck = " + isCheck);
        if (!isCheck.get(y)) {
            System.out.println("y = " + y);
            s.push(y);
        }
    }
    if (s.isEmpty()) return 0;
    return dfs(s.pop());
}
```

재귀
```
    void dfsRecursive(int p) {
        isCheck.set(p, true);
        result += p + " ";
        for (int i = 0; i <g.get(p).size(); i++) {
            int y = g.get(p).get(i);
            if (!isCheck.get(y)) {
                dfsRecursive(y);
            }
        }
    }
```

스택
```
    void dfsStack(int start) {
        int p;
        s.push(start);
        while (!s.isEmpty()) {
            p = s.pop();
            if (!isCheck.get(p)) { // 현재 위치가 체크 된 적이 없으면 // 트리가 아니라 그래프.
                result += p + " ";
                isCheck.set(p, true);
                for (int i = g.get(p).size() - 1; i >=0 ; i--) {
                    int y = g.get(p).get(i);
                    if (!isCheck.get(y)) {
                        s.push(y);
                    }
                }
            }
        }
    }
```

## BFS
너비 우선 탐색

가까운 노드를 우선 적으로

1. 탐색 시작 노드를 큐에 삽입하고 방문 처리

2. 큐에서 노드를 꺼낸 뒤에 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 큐에 삽입하고 방문 처리

3. 2번을 수행할 수 없을 때 까지 반복

최단 경로 문제 해결에 사용

간선의 비용이 동일한 상황에서 최단 거리를 구하는데 이용.

