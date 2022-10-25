# 2022.10.26.

## Longest Consecutive Sequence

[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence)

정렬해서 풀면 시간 복잡도 O(nlogn)

더 쉽게 푸는 방법이 있음

우선 셋에 저장

셋을 돌면서 시작 인덱스를 찾음

왼쪽에 값이 없으면 시작 인덱스

시작 인덱스면 몇 번 연속 되는지 체크

-> nums 전체가 연속 된다면 O(n2) 아닌가? 아래에서 확인

연속 종료시 가장 긴 길이 갱신

### O(n^2) vs O(n)

for 문안에 while 이 있는데, 모든 값이 연속된다고 할 경우 O(n^2) 이 아닌가? 라고 생각했다.

그래서 빅 오 표기법을 내가 잘못 알고 있나 싶어 다시 찾아 봤다.

최악의 경우를 생각 하는 것임.

유투브 댓글을 보고 왜 O(n) 인지 알았음

모든 for 의 인덱스에서 while 문이 n 번 돌경우 n^2 이지만

모든 경우 n 번 도는 것이 아니라. 특정 인덱스에서만 딱 한번 그러기 때문에 시간 복잡도에 영향을 주지 않음

댓글 번역 :
"while look의 사용은 복잡성을 증가시킬 것입니다" 그렇습니다. 그러나 실제로는 아닙니다. while 루프는 시퀀스의 시작을 식별한 경우에만 실행됩니다. 모든 숫자가 시퀀스의 시작은 아닙니다.
100,4,200,1,3,2의 입력과 같이; 숫자 2,3,4의 경우 while 루프도 전혀 실행되지 않습니다 . 비디오에서 그는 모든 숫자가 최대 2번 방문될 것이라고 말했습니다. 최대 *3배라고 생각하지만 전체
시간 복잡도는 여전히 O(n)

### while 문

* As-Is

마지막 값을 갱신해야된다는 생각에 이렇게 했다.

```
while (true){
    // 다음 값 존재
    if(set.contains(num++)){
        count++;
    }else{
        longest = Math.max(count, longest);
        break;
    }
}
```

* To-Be

다음값 존재 할 때까지 반복하고 종료 되면 긴 길이 갱신하면 되므로.

```
while (set.contains(num++)) {
    count++;
}
longest = Math.max(count, longest);
```

### 실행시간 단축

n^2 든 nlogn 이든 너무 오래거리는거 아니야? 라는 생각에 어디가 잘못됐나 계속 찾아봤다.

for each 에서 현재 값을 바꾸면 안되나? -> 전혀 상관 없음

contains 가 무겁나? -> O(1) 임

Math.max 가 무겂나? -> O(1) 임

왜그러나 답답했는데,

for 돌릴때 nums 가 아니라 set 을 돌리니까 훨씬 빨리 종료 됐다.

As-Is

```
for (int num : set) {
```

To-Be

```
for (int num : set) {
```

### Arrays.sort vs Collections.sort()

Arrays.sort

DualPivotQuicksort / 평균 : O(nlog(n)) / 최악 : O(n^2)

Collections.sort

TimeSort / 평균, 최악 : O(nlog(n))

### Big O

https://blog.chulgil.me/algorithm/