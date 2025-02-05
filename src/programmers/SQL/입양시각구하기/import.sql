WITH RECURSIVE hours AS(
    SELECT 0 AS HOUR
UNION ALL
SELECT HOUR + 1 from hours where HOUR < 23
    )

SELECT
    hours.HOUR as HOUR,
    IFNULL(count(ANIMAL_ID),0) as COUNT
FROM
    hours
    LEFT JOIN
    ANIMAL_OUTS ao
ON
    hour(ao.DATETIME) = hours.HOUR
group by
    hours.HOUR
order by
    hours.HOUR