SELECT DATE_FORMAT(datetime, '%H') AS HOUR, COUNT(*) AS COUNT
FROM animal_outs
WHERE DATE_FORMAT(datetime, '%H') BETWEEN 9 and 19
GROUP BY DATE_FORMAT(datetime, '%H')
ORDER BY hour