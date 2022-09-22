# 2022.09.23.

## 고양이와 개는 몇 마리 있을까?

[고양이와 개는 몇 마리 있을까?](https://school.programmers.co.kr/learn/courses/30/lessons/59040)

고양이와 개가 각각 몇 마리인지 조회하는 SQL문 작성

고양이를 개보다 먼저 조회해주세요.

```
SELECT animal_type, COUNT(*) as count
FROM animal_ins
WHERE animal_type = 'Cat' or animal_type = 'Dog'
GROUP BY animal_type
ORDER BY animal_type;
```

## 동명 동물 수 찾기

[동명 동물 수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/59041)

```
SELECT name, COUNT(name) as count
FROM animal_ins
WHERE name is not null
GROUP BY name
HAVING count(name) >= 2
ORDER BY name;
```

FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY
