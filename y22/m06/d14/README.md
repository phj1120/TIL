# 2022.06.14.

# 자료 구조

## 배열(Array)

같은 형의 변수를 여러개 만드는 경우 사용

### ADT

```
객체
<인덱스, 값> 쌍의 집합
연산
create(size)
get(A, i)
set(A, i, v)
```

## 스택(Stack)

데이터를 쌓아 놓은 더미

후입 선출 : Last-In First-Out

가장 최근에 들어온 데이터가 가장 먼저 나감

### ADT

```
객체
0개 이상의 원소를 가지는 유한 선형 리스트

연산
create(size)
is_full(s)
is_empty(s)
push(s, item) : 맨 앞에 데이터 추가
pop(s) : 맨 뒤에 있는 데이터 삭제 & 데이터 조회
peek(s) : 맨 뒤에 있는 데이터 조회
```

## 큐(Queue)

먼저 들어온 데이터가 먼저 나감

선입 선출 : First-In First-Out

### ADT

```
객체
0개 이상의 요소들로 구성된 선형 리스트

연산
create(max_size)
init(q)
is_empty(q)
is_full(q)
enqueue(q, e) : 맨 앞에 데이터 추가
dequeue(q) : 맨 앞에 있는 데이터 삭제 & 데이터 조회
peek(q) : 맨 앞에 있는 데이터 조회
```

선형큐, 원형큐

## 덱(Deque)

double-ended queue

큐의 전단, 후단에서 모두 삽입과 삭제가 가능한 큐

### ADT

```
객체
n 개의 element 형으로 구성된 요소들의 순서있는 모임

연산
create()
init(dq)
is_empty(dq)
is_full(dq)
add_front(dq, e)
add_rear(dq, e)
delete_front(dq)
delete_rear(dq)
get_front(dq)
get_rear(dq)
```

## 리스트

### ADT

```
객체
n 개의 element 형으로 구성된 순서 있는 모임

연산
insert(list, pos, item)
insert_last(list, item)
insert_first(list, item)
delete(list, pos)
clear(list)
get_entry(list, pos)
get_length(list)
is_empty(list)
is_full(list)
print_list(list)
```

배열로 구현

## 연결리스트

리스트를 노드를 이용해 저장

노드 : 데이터 필드 + 링크 필드

## 이중 연결 리스트

선행 노드를 찾기 힘든 단순 연결 리스트의 단점을 해결

하지만 공간을 많이 차지하고(노드에 이전, 이후 링크 포함) 코드가 복잡함

## 우선순위큐(Priority Queue)

우선 순위를 가진 항목들을 저장하는 큐

우선 순위가 높은 데이터가 먼저 나감

### ADT

```
객체
n 개의 element 형의 우선 순위를 가진 요소들의 모임

연산
create()
init(q)
is_empty(q)
is_full(q)
insert(q, x)
delete(q) : 우선 순위가 가장 높은 요소 반환 & 삭제
find(q) : 우선 순위가 가장 높은 요소 반환
```

최소 우선 순위 큐

최대 우선 순위 큐

## 힙(Heap)

노드들의 키들이 key(부모노드) ≥ key(자식노드) or key(부모노드) ≤ key(자식노드) 를 만족하는 완전 이진 트리

최대 힙

key(부모노드) ≥ key(자식노드)

```
    9
   / \
  4   8
 /
1
```

최소 힙

key(부모노드) ≤ key(자식노드)

```
    1
   / \
  4   8
 /
9
```

## 그래프

연결 되어 있는 객체 간의 관계를 표현하는 자료 구조

G(V,E) 로 표시

G : 그래프

V : 정점 (vertices) - 노드

E : 간선 (edge) -링크

# 알고리즘

## DFS(깊이 우선 탐색)

스택 or 재귀 이용해서 구현

- java

    ```java
    public static void dfs(int x) {
        // 현재 노드를 방문 처리
        visited[x] = true;
        System.out.print(x + " ");
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }
    
    dfs(1);
    ```

- python

    ```python
    # DFS 함수 정의
    def dfs(graph, v, visited):
        # 현재 노드를 방문 처리
        visited[v] = True
        print(v, end=' ')
        # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for i in graph[v]:
            if not visited[i]:
                dfs(graph, i, visited)
    
    dfs(graph, 1, visited)
    ```

## BFS(너비 우선 탐색)

큐 이용해서 구현

- java

    ```java
    public static void bfs(int start) {
          Queue<Integer> q = new LinkedList<>();
          q.offer(start);
          // 현재 노드를 방문 처리
          visited[start] = true;
          // 큐가 빌 때까지 반복
          while(!q.isEmpty()) {
              // 큐에서 하나의 원소를 뽑아 출력
              int x = q.poll();
              System.out.print(x + " ");
              // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
              for(int i = 0; i < graph.get(x).size(); i++) {
                  int y = graph.get(x).get(i);
                  if(!visited[y]) {
                      q.offer(y);
                      visited[y] = true;
                  }
              }
          }
    }
    
    bfs(1);
    ```

- python

    ```python
    def bfs(graph, start, visited):
        # 큐(Queue) 구현을 위해 deque 라이브러리 사용
        queue = deque([start])
        # 현재 노드를 방문 처리
        visited[start] = True
        # 큐가 빌 때까지 반복
        while queue:
            # 큐에서 하나의 원소를 뽑아 출력
            v = queue.popleft()
            print(v, end=' ')
            # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for i in graph[v]:
                if not visited[i]:
                    queue.append(i)
                    visited[i] = True
    
    bfs(graph, 1, visited)
    ```

## 다익스트라

- 간단한 다익스트라 알고리즘
    - java

        ```java
        public static int getSmallestNode() {
            int min_value = INF;
            int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
            for (int i = 1; i <= n; i++) {
                if (d[i] < min_value && !visited[i]) {
                    min_value = d[i];
                    index = i;
                }
            }
            return index;
        }
        
        public static void dijkstra(int start) {
            // 시작 노드에 대해서 초기화
            d[start] = 0;
            visited[start] = true;
            for (int j = 0; j < graph.get(start).size(); j++) {
                d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
            }
            // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
            for (int i = 0; i < n - 1; i++) {
                // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
                int now = getSmallestNode();
                visited[now] = true;
                // 현재 노드와 연결된 다른 노드를 확인
                for (int j = 0; j < graph.get(now).size(); j++) {
                    int cost = d[now] + graph.get(now).get(j).getDistance();
                    // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                    if (cost < d[graph.get(now).get(j).getIndex()]) {
                        d[graph.get(now).get(j).getIndex()] = cost;
                    }
                }
            }
        }
        
        dijkstra(start);
        ```

    - python

        ```python
        # 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
        def get_smallest_node():
            min_value = INF
            index = 0 # 가장 최단 거리가 짧은 노드(인덱스)
            for i in range(1, n + 1):
                if distance[i] < min_value and not visited[i]:
                    min_value = distance[i]
                    index = i
            return index
        
        def dijkstra(start):
            # 시작 노드에 대해서 초기화
            distance[start] = 0
            visited[start] = True
            for j in graph[start]:
                distance[j[0]] = j[1]
            # 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
            for i in range(n - 1):
                # 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
                now = get_smallest_node()
                visited[now] = True
                # 현재 노드와 연결된 다른 노드를 확인
                for j in graph[now]:
                    cost = distance[now] + j[1]
                    # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                    if cost < distance[j[0]]:
                        distance[j[0]] = cost
        
        # 다익스트라 알고리즘을 수행
        dijkstra(start)
        ```

- 개선된 다익스트라 알고리즘
    - java

        ```java
        public static void dijkstra(int start) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
            pq.offer(new Node(start, 0));
            d[start] = 0;
            while(!pq.isEmpty()) { // 큐가 비어있지 않다면
                // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
                Node node = pq.poll();
                int dist = node.getDistance(); // 현재 노드까지의 비용 
                int now = node.getIndex(); // 현재 노드
                // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
                if (d[now] < dist) continue;
                // 현재 노드와 연결된 다른 인접한 노드들을 확인
                for (int i = 0; i < graph.get(now).size(); i++) {
                    int cost = d[now] + graph.get(now).get(i).getDistance();
                    // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                    if (cost < d[graph.get(now).get(i).getIndex()]) {
                        d[graph.get(now).get(i).getIndex()] = cost;
                        pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                    }
                }
            }
        }
        
        dijkstra(start);
        ```

    - python

        ```python
        def dijkstra(start):
        		q = []
            # 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
            heapq.heappush(q, (0, start))
            distance[start] = 0
            while q: # 큐가 비어있지 않다면
                # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
                dist, now = heapq.heappop(q)
                # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
                if distance[now] < dist:
                    continue
                # 현재 노드와 연결된 다른 인접한 노드들을 확인
                for i in graph[now]:
                    cost = dist + i[1]
                    # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                    if cost < distance[i[0]]:
                        distance[i[0]] = cost
                        heapq.heappush(q, (cost, i[0]))
        
        # 다익스트라 알고리즘을 수행
        dijkstra(start)
        ```

## 이진 탐색

- python

    ```python
    def binary_search(array, target, start, end):
        if start > end:
            return None
        mid = (start + end) // 2
        # 찾은 경우 중간점 인덱스 반환
        if array[mid] == target:
            return mid
        # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        elif array[mid] > target:
            return binary_search(array, target, start, mid - 1)
        # 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else:
            return binary_search(array, target, mid + 1, end)
    
    result = binary_search(array, target, 0, n - 1)
    ```

- java

    ```java
    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        // 찾은 경우 중간점 인덱스 반환
        if (arr[mid] == target) return mid;
        // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else return binarySearch(arr, target, mid + 1, end);
    }
    
    int result = binarySearch(arr, target, 0, n - 1);
    ```

## Reference

* 이것이 취업을 위한 코딩 테스트다

  https://github.com/ndb796/python-for-coding-test