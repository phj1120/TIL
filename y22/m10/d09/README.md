# 2022.10.09.

# 입국 심사

[입국 심사](https://school.programmers.co.kr/learn/courses/30/lessons/43238#)

이분 탐색 문제

처음엔 이게 왜 이분 탐색이지가 이해가 안됐었다.

하다보니 그 부분은 이해가 됐지만, 이분탐색 구현이 어려웠다.

코테전 가볍게 보고 가려고 한 문제였는데, 어쩌다 보니 코테 끝나고 2시간 넘게 끙끙 대고 있었다.

다시 풀라고하면 쉽지 않을 것 같다.

나중에 시간 지나고 다시 풀어봐야지

### 초기 left, right 값

AS-IS

```
left = n
right  = (가장 심사 오래 걸리는 심사위원) * n
```

이해가 안되어 이 블로그 저 블로그 돌아디니며으로 본 것 같아 그냥 쭉 이렇게 해왔다.

TO-BE

```
left = n
right  = (가장 심사 오래 걸리는 심사위원) * n
```

### 찾는 값 중 가장 작은 값 찾기

* AS-IS

    ```
    public long binarySearch1(long left, long right, int n, int[] times) {
        long mid = (left + right) / 2;
        long completedCount = 0;
        for (int time : times) {
            completedCount += mid / time;
        }
    
        if (completedCount == n) {
            return mid;
        } else if (completedCount < n) {
            return binarySearch(mid + 1, right, n, times);
        } else {
            return binarySearch(left, mid - 1, n, times);
        }
    }
    ```

  이 코드는 비교하는 값에 중복이 없다고 가정하면 정답일 수 있지만,

  해당 시간에 입국 심사를 받은 사람 수를 기준으로 이분 탐색 하는 것이므로 중복이 존재한다.

  그래서 위의 경우 중복이 있을 경우를 처리 하지 못해 문제가 발생했다.


* TO-BE

    ```
    public long binarySearch(long left, long right, long n, int[] times) {
        if(left<right) {
            long mid = (left + right) / 2;
            long nowCompletedCount = 0;
            for (int time : times) {
                nowCompletedCount += mid / time;
            }
            if (nowCompletedCount >= n) {
                return binarySearch(left, mid, n, times);
            } else {
                return binarySearch(mid +1, right, n, times);
            }
        }
        return left;
    }
    ```

  원하는 값 중 가장 작은 인덱스를 값을 찾는 방법.

  원하는 값을 찾아도 왼쪽으로 계속 탐색하고,

  왼쪽 값을 반환하면 가장 작은 인덱스? 일단 이 문제에서 원하는 값이 반환 된다!

### 가장 큰 값

* 정렬 후 가장 마지막 값

  ```
  Arrays.sort(times);
  long right = (long) times[times.length - 1] * n; // (long * int = long)
  
  테스트 1 〉 통과 (0.57ms, 84MB)
  테스트 2 〉 통과 (0.45ms, 65.2MB)
  테스트 3 〉 통과 (1.78ms, 77.2MB)
  테스트 4 〉 통과 (85.66ms, 81.4MB)
  테스트 5 〉 통과 (92.76ms, 89MB)
  테스트 6 〉 통과 (67.55ms, 105MB)
  테스트 7 〉 통과 (104.44ms, 103MB)
  테스트 8 〉 통과 (87.34ms, 87.2MB)
  테스트 9 〉 통과 (0.51ms, 78.7MB)
  ```

* 스트림 이용해 최대 값

  ```
  long right = (long) Arrays.stream(times).max().getAsInt() * n; // (long * int = long)
  
  테스트 1 〉 통과 (0.69ms, 74.1MB)
  테스트 2 〉 통과 (1.03ms, 77.4MB)
  테스트 3 〉 통과 (2.05ms, 76.8MB)
  테스트 4 〉 통과 (70.67ms, 99.5MB)
  테스트 5 〉 통과 (45.67ms, 98.6MB)
  테스트 6 〉 통과 (41.46ms, 84.8MB)
  테스트 7 〉 통과 (53.96ms, 109MB)
  테스트 8 〉 통과 (55.24ms, 93.4MB)
  테스트 9 〉 통과 (0.86ms, 81.3MB)
  ```

크게 차이는 없어서 그냥 써도 될 듯하나 생각해 봐도

정렬 보다 스트림으로 최대값 구하는게 빠른 것 같다.

