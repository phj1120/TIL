# 2022.06.02.

아쉽게도 오늘도 TIL 이다.

어제 프로젝트 혼자 마무리 했다고 생각해서

이제 개인 공부 할 생각에 부풀어있었는데

프론트 하는 친구와 합쳐보니까 생각하지 못한 부분에서 오류와 실수가 나왔다.

하루 종일 이거만 수정했다.

진짜 TEST 코드의 중요성 느끼고 있다.

다행히 Mapper 까지는 어느 정도 해놔서 테스트를 통과하면 거기 까지는 안전하다는 믿음으로 이후의 부분을 수정한다.

빨간 점 찍는 디버거도 진짜 유용하다는 것을 느끼고 있다.

이거 없었으면 훨씬 더 오래 걸렸을 것 같다.

### Get 요청에 HTTP BODY 를 담아주고 있었다.

GET 은 HTTP BODY 없음

파라미터로 변경

### 인증번호 요청, 확인

```
인증 번호 전송 요청 할때(/api/auth/send/auth-key)
type : 00, 01 필수
00 : 비밀번호 찾기 - DB 에 있는 회원 정보와 비교 해서 일치할 경우에만 인증 번호 전송
01 : 회원 가입 - DB 에 회원 정보가 없을 경우에만 인증 번호 전송

인증 번호 확인 할때도(/api/auth/check/auth-key)
type : 00, 01 필수
00 : 비밀번호 찾기(jwt, check 응답 or 에러 )
01 : 회원 가입 ( check 응답 or 에러 )
```

인증 요청한 종류에 맞는 응답만 가능 하도록 설정

DB tb_authkey 에 TYPE int not null 속성 추가

( 회원 가입시 요청한 이메일 인증번호 가지고 type 만 바꿔서 보내면 jwt 를 받을 수 있어서 이 문제 방지하기 위함)

### org.springframework.dao.DataIntegrityViolationException

일정 내용 비어있으면 에러 발생

-> schedule content 코드에서는 선택 값인데

DB 에는 Not Null 로 되어있음

수정.

### LocalDateTime 응답

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")

    "endTime": [
    2020,
    3,
    19,
    0,
    58,
    23
    ],


    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")

    "endTime": "2020-03-19T00:58:23",

