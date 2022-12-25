SELECT
    h.num as HOUR,
    COUNT(ao.ANIMAL_ID) as COUNT
FROM
    ANIMAL_OUTS as ao
        RIGHT OUTER JOIN(
        WITH RECURSIVE hours as(
            SELECT 0 AS num
            UNION ALL
            SELECT num+1 FROM hours WHERE num < 23
        )
        SELECT num FROM hours
    )as h
ON
    h.num = HOUR(ao.DATETIME)
GROUP BY
    h.num