# JOIN

[조인 공부 자료](https://chlgpdus921.github.io/basecamp/MySQL-JOIN/)

## 없어진 기록 찾기

[없어진 기록 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/59042)

입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문

```
SELECT ao.animal_id, ao.name
FROM animal_outs as ao
    LEFT JOIN animal_ins as ai 
    ON ai.animal_id = ao.animal_id
WHERE ai.datetime is null && ao.datetime is not null;
```

## 있었는데요 없었습니다

[있었는데요 없었습니다](https://school.programmers.co.kr/learn/courses/30/lessons/59043)

보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문

결과는 보호 시작일이 빠른 순으로 조회

```
SELECT ai.animal_id, ai.name
FROM animal_ins as ai 
    JOIN animal_outs as ao 
    ON ai.animal_id = ao.animal_id
WHERE ai.datetime > ao.datetime
ORDER BY ai.datetime;
```

## 오랜 기간 보호한 동물(1)

[오랜 기간 보호한 동물(1)](https://school.programmers.co.kr/learn/courses/30/lessons/59044)

아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문

결과는 보호 시작일 순으로 조회

```
SELECT ai.name, ai.datetime
FROM animal_ins as ai 
    LEFT JOIN animal_outs as ao
    ON ai.animal_id = ao.animal_id
WHERE ao.datetime is null
ORDER BY ai.datetime
LIMIT 3;
```

## 보호소에서 중성화한 동물

[보호소에서 중성화한 동물](https://school.programmers.co.kr/learn/courses/30/lessons/59045)

보호소에 들어올 당시에는 중성화 되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의

아이디와 생물 종, 이름을 아이디 순으로 조회하는 SQL 문

```
SELECT ai.animal_id, ai.animal_type, ai.name
FROM animal_ins as ai
    JOIN animal_outs as ao
    ON ai.animal_id = ao.animal_id
WHERE ai.sex_upon_intake LIKE 'Intact%'
    AND (ao.sex_upon_outcome LIKE 'Spayed%'
         OR ao.sex_upon_outcome LIKE 'Neutered%');
 ```

중성화가 아니면 성별 바뀔일 없으니까.

```
SELECT ai.animal_id, ai.animal_type, ai.name
FROM animal_ins as ai
    JOIN animal_outs as ao
    ON ai.animal_id = ao.animal_id
WHERE ai.sex_upon_intake != ao.sex_upon_outcome;
```

