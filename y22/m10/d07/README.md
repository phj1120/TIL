# 2022.10.07.

## 연구소

[연구소](https://www.acmicpc.net/problem/14502)

[이코테 코드](https://github.com/ndb796/python-for-coding-test/blob/master/13/2.java)

BFS 로 구현 한 것 보다 DFS 로 구현한게 알아보기 쉬웠다.

DFS 는 static 변수 써야 되서 쓰기 꺼려졌다.

이해 잘 되는건 메서드로 잘뽑아서 그런건가?

### BufferedReader vs Scanner

* BufferedReader

  소요 시간 : 584ms

    ```
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line1 = br.readLine().split(" ");
    int n = Integer.parseInt(line1[0]); // 세로
    int m = Integer.parseInt(line1[1]); // 가로
    
    int[][] maps = new int[n][m];
    for (int i = 0; i < n; i++) {
        String[] data = br.readLine().split(" ");
        for (int j = 0; j < m; j++) {
            maps[i][j] = Integer.parseInt(data[j]);
        }
    }
    ```

* Scanner

  소요 시간 : 724ms

    ````
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] maps = new int[n][m];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            maps[i][j] = sc.nextInt();
        }
    }
    ````

### 가독성 향상

dfs 가 코드가 간단해서 이코테 코드가 이해가 잘 된게 아니라

메서드로 뽑고 깔끔한 스타일로 코딩 했기 때문에 이해가 잘 된거였다.

기능들 메서드로 추출해서 가독성 좋게 만들었다.

코드의 전체적인 흐름이 이해가 잘 됐다.

코테 보고 시간 애매하게 남으면 이렇게 코드 정리나 해둬야겠다.

근데 수행 시간이 줄었다?

* Scanner

  724ms -> 536ms

* BufferedReader

  584ms -> 448ms

이건 왜 그런지 모르겠다 생각해 봐야지.
