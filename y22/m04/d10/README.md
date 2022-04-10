# 2022.04.10.

이코테 답과 내 답을 비교해 보고 어떻게 코드를 짜야할지 공부해 봤다.

## DFS
재귀 시 void 를 반환하지 않고

    static void dfs(int x, int y) {
    
    if (arr[i][j] == 1) {
        dfs(j, i);
        cnt++;
    }
    
boolean 을 반환

    static boolean dfs(int x, int y) {

    if (dfs(i, j)) {
        result += 1;
    }

이게 더 좋은 코드로 보인다.

## 입력
입력도 더 간편하게 바꿨다.(시간 차이는 다이나믹하게 차이나진 않음)

    for (int i = 0; i < n; i++) {
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(strArr[j]);
        }
    }


## Q4963 과 얼음 만들기 차이
Q4963 에는 대각선 까지 주어지고 0 과 1 기준이 다름

* 얼음 만들기


    public static boolean dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y > m) { // 주어진 범위 벗어나는 경우 종료
            return false;
        }

        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }


* Q4963
 

    static boolean dfs(int x, int y) {
        if (x <= -1 || x >= m || y <= -1 || y >= n) { // 주어진 범위 벗어나는 경우 종료
            return false;
        }
        int[] arrX = {x - 1, x, x + 1};
        int[] arrY = {y - 1, y, y + 1};

        if (arr[y][x] == 1) {
            arr[y][x] = 0;
            for (int i : arrY) {
                for (int j : arrX) {
                    dfs(j, i);
                }
            }
            return true;
        }
        return false;
    }


## 실수

예시 결과는 맞는데 왜 틀렸다고 뜨지?

는 메인에서 dfs(j, i) 를 dfs(i, j) 로 입력해서 틀림


## arr[x][y] arr[y][x]

dfs 는 dfs(x, y)

arr 는 arr[y][x]

살짝 달라 헷갈린다.

예제는 arr[x][y] 해도 문제 없는데 왜 나는 arr[y][x] 로 했나?

    for (int[] subArray : graph) {
        System.out.println(Arrays.toString(subArray));
    }
    System.out.println();

-> 출력 쉽게하려고 그랬다.

꼭 그래야만 됐나?
-> 그냥 그래야 될 것 같아서 그렇게 한거임

다시 생각해 보니까 저장할 때 방식만 바꾸면 arr[x][y] 를 해도 제대로 출력할 수 있음

    for (int i = 0; i < h; i++) {
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        for (int j = 0; j < w; j++) {
            arr[j][i] = Integer.parseInt(strArr[j]);
        }
    }

값을 이렇게 입력 받아오면 됨.

얼음 만들기 문제의 경우 처음부터 1000, 1000 이렇게 초기화 해줘서 

    for (int i = 0; i < n; i++) {
        String str = sc.nextLine();
        for (int j = 0; j < m; j++) {
            graph[i][j] = str.charAt(j) - '0';
        }
    }

90도 회전된 방식으로 초기화 되도 문제 없지만 

나의 경우 크기에 딱 맞게 초기화 했기 때문에 Index 오류가 났다.


## 소감

사소한 것이라고 대충 생각하면 안되겠다.

살짝만 달라도 결과가 확 달라진다.

왜 안되는지, 왜 다른지 찾는게 진짜 힘들었다.