#2022.04.11.
# 최단 거리 = BFS
## 미로탐색(2178)
요즘 DFS 재귀만 했더니 별 고민 없이 이거로 시도했다. 풀이법이 보였다.

푼 듯 했지만 틀렸다. 순서에 따라 갇힌다.  작은 값 카운트가 안된다.

-> 왜 안되지? 로직이 잘못 된건가

원래 하루 한시간 보려고 했는데...

한 3시간 이거만 보니까 머리가 더 안 돌아간다.

내일 다시 봐야겠다. 

는 짜증나서 머리 좀 식히고 다시 봤다.

다른 사람은 어떻게 했나 찾아봤다.

    public static void dfs(int[][] maze, int distance, int x, int y){
        if (x <= -1 || x >= m || y <= -1 || y >= n) {
            return;
        }
        if (x == m - 1 && y == n - 1) {
            minDistance = distance;
            distances.add(distance);
            return;
        }
        if (maze[x][y] == 1) {
            maze[x][y] = 0;
            dfs(maze, distance + 1, x, y - 1);
            dfs(maze, distance + 1, x, y + 1);
            dfs(maze, distance + 1, x -1, y);
            dfs(maze, distance + 1, x +1, y);
            maze[x][y] = 1; // 이전 분기점 까지 값 원위치 
        }
    }

maze[x][y] = 1; 을 고려하지 못했었다.

도착지에 도착할 경우, 이 길이 아닐 경우 다른 길로 가기 위해 다른 갈래길로 복귀.

이때 잘 못 온 길을 1로 원위치 한다.

재귀함수는 시스템에 Stack 으로 쌓여있음

시간 초과는 났지만 문제는 해결 됨.

다른 알고리즘으로 풀어보기

## 소감

고민하다 보니까 뭔가 DP 로도 풀 수 있을 것 같다.
내일은 우선 DP로 풀어보고 BFS 로 풀어 봐야겠다.


## 참고자료
https://roxxy.tistory.com/entry/%EA%B9%8A%EC%9D%B4-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89DFS-Depth-First-Search