# 2022.05.24.

# 프로젝트 진행

# 의문

DB 에서 값 읽어오는 Mapper 작성 중 no 로 조회하면 하나, userId 로 조회하면 여러개 반환 하도록 할 예정

1번.

```
ScheduleVo selectByNo(Integer ScheduleNo);
List<ScheduleVo> selectByUserId(String userId);
+ mapper에 각각 추가
```

2번.

```
List<ScheduleVo> select(ScheduleVo scheduleVo);
+ mapper 에 mybatis 동적 쿼리 사용해 하나만 추가
```

1번은 메서드명이 확실해서 사용할 때 혼동은 없을 것 같은데

그러면 mapper 를 각각 추가해야 되고 추후 수정 사항이 있으면 불편할 것 같다고 생각

2번은 유연하게 사용할 수 있는 점은 좋은데

의도하지 않은대로 사용 될 수 있을 것 같다는 생각

# 답

여러 사람들한테 물어본 결과 1번 추천

코드 몇 줄 더 수정한다고 유지 보수가 힘들다는 단순한 생각.

마이바티스는 실 쿼리 날리기 전까진 구문 에러조차도 알수 없어서

하나 만들어서 여러 목적으로 쓰면 쿼리 수정했을때 어디 한 군데서 원하는대로 안 돌아갈 가능성이 생김

# Service? Controller?

지금까지 내가 짠 코드를 보면 Controller 에 로직이 다 있고

Service 는 단순히 Mapper 에서 가져온거 한 번 더 처리하는 의미 없는 작업이었음

오늘 감사하게도 멘토링을 받았는데 이해 잘가게 알려주셨음

Service 에 트랜잭션 처리와 함께 로직을 담고

Controller 에서는 단순하게 호출만 할 수 있도록 해라. 컨트롤러는 전달자 느낌.

클라이언트가 원하는 정보를 DTO 에 담아줌

DB 에 따라 Controller, Service 를 나누지 말고 서비스에 맞게 나눠라.

나는 response 에 result 에 상태를 담았는데

그러지 말고 Service 에서 Exception Handler 이용해라.

Response, Request 둘 다 Json 으로 주고 받아라. (@ResponseBody @RequestBody)

Map 에 담아 반환하는 것은 빠르게 개발할 때는 좋지만 무슨 값이 들어가는지 몰라 @ResponseEntity 를 사용하는 것이 좋다.

변경이 없는 파라미터에는 final 을 써주자.

HTTP 메서드 PUT과 PATCH는 규약일 뿐 강제가 아님 (이분은 PATCH 에 문제가 있어 PUT 으로 자주 사용 [참고](https://www.inflearn.com/questions/93071))

@Autowired 보다는 private final + @RequiredArgsConstructor 해서 생성자 주입 권장.

# PUT / PATCH

PupMapping, PatchMapping 으로 요청을 받으면 파라미터가 안 받아진다...

동일한 방식으로 Post 는 되는데 위의 둘은 안된다.

값 바꿔보고 검색해 봐도 해결이 안된다. 이건 계속 해봐야 할 것 같다.

# 감사

오픈 카톡으로 다짜고짜 질문을 했는데 잘 알려주시고 보이스톡에 원격 제어까지 이용해서 알려주셨다...!

갑자기 멘토링을 받아서 너무 좋았다.

가장 궁금했던 서비스, 컨트롤러 나누는 것, 위의 질문,

포스트맨 사용 팁, 인텔리 제이 디버그, 기타 편리한 기능 이용하는 것 등등

퇴근 하고 오셔서 힘드실텐데 두 시간 가까이 시간 내어 알려주셨다.

나에게는 한 달 그 이상의 가치가 있었다.

안 도와주셨으면 제대로 하고 있는 건지 아닌지도 모르고 혼자 끙끙대고 있었을 것 같다.

확실히 느낀건 멘토가 필요하다.

내가 숨어 있는거지 세상엔 좋은 사람들이 많다.

나도 이렇게 도와줄 수 있는 사람이 되어야겠다.

그리고 요즘 신규 프로젝트 SpringBoot + JPA 로 하는데 왜 Spring + Mybatis 를 하세요?

음...... 교수님이 부트 쓰지 말라고 하셔서?

교수님이랑 하는 건 스프링 프레임워크 쓰고 혼자 하는 건 스프링 부트를 하려 했다.

근데 내가 가고 싶은 곳은 혹은 내가 되고 싶은 사람들은 부트를 쓰는데 이렇게 하는게 맞나?

사실 지금까지 한게 코드에 대해 익숙해지는 과정이었지

스프링, 마이바티스 깊게 한 것도 아니라 괜찮긴하다.

퇴사 주도 개발 한다 생각하고 더 열심히 공부 해야 겠다.

뭔가 감이 잡혔다.

자바 - 예외처리, 제네릭 / JPA / Spring - Exception Handler
