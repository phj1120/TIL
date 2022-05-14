# 2022.05.14.

DFS, BFS 도 풀어 봤는데 한 달 정도 지나니까 기억이 안난다.

정리 해둔걸 봤는데 정리가 안된 느낌이라 봐도 모르겠다.

나중에 까먹을때마다 보게 잘 정리해둬야지

[DFS, BFS](https://parkhj.notion.site/DFS-BFS-b9f8b256faf841abbc19b1ade7b0d399)

# 자바 배열 사용 방법

```
    int[][] pic1 = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    
    int[][] pic2 = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

    int[][] pic3 = new int[6][4];
    for (int i = 0; i< pic3.length; i++){
        for(int j = 0; j<pic3[i].length; j++){
            pic3[i][j] = 0;
        }
    }
   
    int[][] pic4 = new int[6][4];

    for (int i = 0; i<pic4.length; i++){
        Arrays.fill(pic4[i], 0);
    }
```

