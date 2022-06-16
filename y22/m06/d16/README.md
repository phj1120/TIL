# 2022.06.16.

# 신고 결과 받기

[신고 결과 받기](https://programmers.co.kr/learn/courses/30/lessons/92334?language=java)

신고 한 사람이 정지 당하면 suspensionIds 라는 곳에 저장 하도록 했다.

근데 이걸 추가 하는 기준을 k 번 넘을 경우로 해서

이미 정지 당했는데 또 신고 당하면 중복으로 추가 됐다.

이 부분 로직을 수정해서 통과 했다.

근성으로 풀긴 했는데.... 이것보다 분명 좋은 방법이 있을 것 이다.

다른 사람 코드 봐야지

단순히 코드가 길어서 안 좋은 코드가 아니라,

모호한 이름 때문에 알아 보기 쉽지 않아서 안 좋은 코드 인 것 같다.

```
for (String reportLog : report) {
    ...
    // 정지 기준을 넘은 경우 내가 신고 해서 정지 된 사람 추가.
    if (daesangReport.getReportCount() >= k) {
        for (String id : daesangReport.getReporterIds()) {
            if (memberList.get(id).wasSuspension(daesang)) continue;
            memberList.get(id).addSuspensionId(daesang);
        }
    }
    ...
```

더 고민해 보면 좋은 방법이 있을 듯....

처음 기준을 넘었을 경우에만 for 로 정지 목록에 추가하고,

그 다음부터는 신고한 사람 거에만 정지 목록에 추가하면 되지 않을까?

```
for (String reportLog : report) {
    ...
    if (daesangReport.getReportCount() == k){
        for (String id : daesangReport.getReporterIds()) {
            memberList.get(id).addSuspensionId(daesang);
        }
    } else if (daesangReport.getReportCount() > k) {
        singojaReport.addSuspensionId(daesang);
    }
```

소요 시간이 훨씬 줄었다. wasSuspension 메서드도 필요 없어 졌다.

wasSuspension 에도 for 가 있어서 삼중 for 문이 었다....!

두 번째 for 가 k (정지 기준) 고, 한번만 실행 되니까

여기서 이중 for 문은 괜찮은 것 같다.

다른 분이 짠 것 처럼

사용자 객체에 내가 신고 했는데 정지 된 사람. 리스트를 두는 것 보다.

suspendedList 를 한 번에 둬서 마지막에 객체를 다 까보는 것도 나쁘지 않은 것 같다.

```
for (User user : users) {
    for (String nameReport : user.reportList) {
        if (suspendedList.get(nameReport) != null) {
            answer[idIdx.get(user.name)]++;
        }
    }
}
```

유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.

라는 문제 조건에도 부합하네.

오.... 이런 조건이 있네...

내 코드에 주석 달면서 보니까 singoja, daesang 은 너무 했긴 한데 나름 괜찮다?
