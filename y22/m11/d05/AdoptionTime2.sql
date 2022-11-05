SET
@hour = -1;
SELECT (@hour := @hour +1) AS HOUR,
    (SELECT COUNT(*) FROM animal_outs ao
    WHERE @hour = HOUR(ao.datetime))
FROM animal_outs
WHERE @hour < 23;