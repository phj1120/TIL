# 2022.06.01.

# TIL

## Mysql 버전 업그레이드

AWS 에 설치된 mysql 버전이 5.x 였다.

큰 상관 없을 줄 알았는데 오늘 버전 차이를 느꼈다.

로컬 (8.x) 에서는 에러 발생 X

-> AWS 에 올리니 특정 상황에서만 에러 발생 (org.apache.ibatis.exceptions.PersistenceException)

-> 상황 분석 mybatis 에러인가... 한글 입력 시에만 에러 발생

-> mybatis 한글 에러 검색해도 결과가 나오지 않아

-> 테이블 변경사항이 적용 안 됐나? local DB mysqldump 로 백업 후 적용 시도

-> 에러 발생 (unknown collation utf8mb4_0900_ai_ci) -> 5.x 에서는 utf8mb4_0900_ai_ci 지원 하지 않음

-> DB 업그레이드 -> 에러 해결

* 참고 자료

https://m.blog.naver.com/theswice/221321015924

https://parkhj.notion.site/Ubuntu-a8ae126e88634682a6b0a4ea1df8855b

## 프로젝트 기능 구현 마무리

1차로 마무리 완료

공부 Spring Boot, JPA, JUnit 시작할 예정

기능 잘 못 구현 된 부분 찾아서 고치는데 시간 보냄

뭘 만들어야하나를 명확하게 정하지 않고 만들것을 머리속으로 정하고 코딩했다.

머리속에서 꼬여서 기능도 이상하게 구현됨

알고리즘 문제 풀 듯이 뭘 만드려고 하는지, 뭐가 필요한지 생각 하고 생각을 코드로 옮김

어렵지 않게 구현 할 수 있었음

더 좋은 코드로 만들고 싶음

메서드로 나누고 조건을 잘 건드려 보면 더 간단하게 처리할 수 있을 것 같음

```
    // 목록 조회
    // 1. 완료 O
    // 2. 완료 X, 기한 O ( 기한 지난 것, 안 지난 것 구분)
    // 3. 완료 X, 기한 X
    public ResponseEntity<List<ScheduleShortInfo>> findScheduleList(
            final String userIdInJwt, final String userId, final ScheduleStatusDto scheduleStatusDto) {
        Boolean requestIsComplete = scheduleStatusDto.getIsComplete();
        Boolean requestHasDeadLine = scheduleStatusDto.getHasDeadLine();

        // 필수 인자가 없는 경우
        if (userIdInJwt == null || userId == null || requestIsComplete == null) {
            throw new ValueException("필수 인자가 없습니다.");
        }

        // 완료 되지 않은 일정 조회 시 기한이 있는 것 없는 것 구분 필수
        if (!requestIsComplete && requestHasDeadLine == null) {
            throw new ValueException("필수 인자가 없습니다.");
        }

        // TODO 친구 기능 추가 시 권한 확인하는 코드 작성 필요, 현재 본인 정보만 조회 가능.

        // 본인이 아닐 경우
        if (!userId.equals(userIdInJwt)) {
            throw new DifferentAuthException("접근 할 수 있는 권한이 없습니다.");
        }

        List<ScheduleVo> scheduleList = scheduleMapper.selectByUserId(userId);

        ArrayList<ScheduleShortInfo> scheduleShortInfoList = new ArrayList<>();

        for (ScheduleVo schedule : scheduleList) {
            Integer no = schedule.getNo();
            String title = schedule.getTitle();
            LocalDateTime endTime = schedule.getEndTime();
            Boolean isComplete = schedule.getIsComplete();

            // TODO 친구 기능 추가 시 조회한 schedule 의 isPublic 을 기반으로 공개 여부 추가 할 것.

            // 완료된 일정 조회
            if (requestIsComplete) {
                if (!isComplete) continue; // 완료되지 않은 일정일 경우 처리하지 않음

                ScheduleShortInfo scheduleShortInfo = new ScheduleShortInfo().builder().no(no).title(title).build();
                scheduleShortInfoList.add(scheduleShortInfo);
            } else if (requestHasDeadLine) {
                // 완료 되지 않고 기한이 있는 일정 조회
                if (isComplete || endTime == null) continue; // 완료 되었거나 기한이 없는 일정일 경우 처리하지 않음

                // 기한이 지난 것, 기한이 지나지 않은 것으로 구분해 반환
                LocalDateTime now = LocalDateTime.now();
                Boolean overDeadLine = now.isAfter(endTime);

                ScheduleShortInfo scheduleShortInfo = new ScheduleShortInfo().builder().no(no).title(title).overDeadLine(overDeadLine).build();
                scheduleShortInfoList.add(scheduleShortInfo);
            } else {
                // 완료 되지 않고 기한이 없는 일정 조회
                if (isComplete || endTime != null) continue; // 완료 되었거나 기한이 있는 일정일 경우 처리하지 않음

                ScheduleShortInfo scheduleShortInfo = new ScheduleShortInfo().builder().no(no).title(title).build();
                scheduleShortInfoList.add(scheduleShortInfo);
            }
        }
        return ResponseEntity.ok().body(scheduleShortInfoList);
    }
``'