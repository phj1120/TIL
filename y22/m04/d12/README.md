## 2022.04.12.

2022.04.05. 내용 참고.
## BFS
너비 우선 탐색

가까운 노드를 우선 적으로

1. 탐색 시작 노드를 큐에 삽입하고 방문 처리

2. 큐에서 노드를 꺼낸 뒤에 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 큐에 삽입하고 방문 처리

3. 2번을 수행할 수 없을 때 까지 반복

최단 경로 문제 해결에 사용

간선의 비용이 동일한 상황에서 최단 거리를 구하는데 이용.


    public static void main(String[] args) {
        init();
        Queue<Integer> q = new LinkedList();
        q.offer(1);
        isCheck.set(1, true);
        while (!q.isEmpty()) {
            int p = q.poll();
            result += p + " ";

            for (int i = 0; i < g.get(p).size(); i++) {
                int y = g.get(p).get(i);
                if (!isCheck.get(y)) {
                    q.offer(y);
                    isCheck.set(y, true);
                }
            }
        }
        System.out.println(result);
    }

### [MazeBfsFail](MazeBfsFail.java)
![](BFS(미로탐색).jpg)
탐색은 했는데 최단 거리는 어떻게 구하나?

노드 수를 구할 수 있으면 좋은데.

### [MazeBfsMix](MazeBfsMix.java)
아이디어가 안 떠올라 답 보고 수정 

-> 미로에 칸 수를 적는 방법으로 해결

### [MazeBfsSol](MazeBfsSol.java)

이코테 정답 코드 

진짜 깔끔하게 잘 짰다.


* 내 코드


    int[] xList = {x, x, x - 1, x + 1};
    int[] yList = {y - 1, y + 1, y, y};
    distance = maze[y][x];
    for (int i = 0; i < xList.length; i++) {
        x = xList[i];
        y = yList[i];
        // 해당 범위를 벗어날 경우 무시
        if (x >= m || x < 0 || y >= n || y < 0) continue;
        
        ...
        // 처음 방문 하는 경우
        if (maze[y][x] == 1) {
            map = new HashMap<String, Integer>();
            map.put("x", x);
            map.put("y", y);
            q.offer(map);
            maze[y][x] = distance + 1;
        }

* 이코테 코드


    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        // 미로 찾기 공간을 벗어난 경우 무시
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

        ...

        // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
        if (graph[nx][ny] == 1) {
            graph[nx][ny] = graph[x][y] + 1;
            q.offer(new Node(nx, ny));
        }

클래스로 Node 지정

상하좌우 탐색을 위한 새로운 값 선언

## 내일은
어찌저찌 DFS, BFS 가 끝났다.

자료구조 수업 때문에 갑자기 스택 큐 넘어왔다가 DFS, BFS 를 했다.

시간이 오래 걸렸고 어려웠지만 풀고 나니 재밌었다.

내일은 다시 이코테 그리디로 돌아가야겠다.