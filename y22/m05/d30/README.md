# 2022.05.30.

# TIL

## 스웨거 적용 완료

[Swagger](https://parkhj.notion.site/Swagger-9af2ec26176f46a3b382e0ff1f033967)

## 프로젝트 진행도

사용자 정보, 인증 관련 기능 구현 완료

메시지 응답이 마음에 들지는 않지만

일단 한 싸이클 돌려보고 점점 개선해 나가려고 함.

## 메서드 명명 규칙 지정

### Service

```
find~
add~
modify~
remove~
save~
```

### Controller

```
~List()
~Details()
~Save()
~Add()
~Modify()
~Remove()
```

### Mapper

```
select~
insert~
update~
delete~
```

### 구조

* 컨트롤러는 서비스를 호출하기만 한다.

* 서비스에서는 예외처리, 트랜잭션 처리를 한다.

* 메서드는 한가지의 기능만 가져야 한다.

## Reference

https://cocobi.tistory.com/27



