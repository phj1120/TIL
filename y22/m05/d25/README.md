# 2022.05.25.

프로젝트 재밌다...

어제 PUT / PATCH 안 되던 이슈 해결 했다.

원래 form-data 는 브라우저에서 POST 로 하는 요청

근데 브라우저 아닌 환경에서 PUT, PATCH 로도 보낼 수 있음

톰캣 기본 설정에 POST 는 파라미터를 가져올 수 있도록 하는 설정이 기본으로 되어 있지만

PUT, PATCH 는 아님 따로 필터를 등록해주거나 톰캣 설정을 변경해야함

임베디드 톰캣은 해당 이슈 없음

web.xml 에 아래 필터 추가해서 해결 했음

```
<filter>
    <filter-name>putMapping</filter-name>
    <filter-class>org.springframework.web.filter.FormContentFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>putMapping</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#filters-http-put

http://hwannnn.blogspot.com/2018/07/putdeletemapping-body.html

# 자료구조

이진 탐색을 이렇게 진도를 빼시는거에 놀랐다.

이게 의미 있는 수업일까 의문이 들었다.

진도 맞춰서 공부하는 느낌으로 활용 해야겠다.

책에 있는 코드인데 왼쪽 삭제 시 연관 노드가 삭제 되는 이슈가 있다.

수정 해 봐야겠다.