WITH RECURSIVE relations AS (
    SELECT
        ID,
        PARENT_ID,
        1 AS GENERATION
    FROM
        ECOLI_DATA
    WHERE
        PARENT_ID IS NULL
    UNION ALL

    SELECT
        c.ID,
        c.PARENT_ID,
        p.GENERATION + 1 AS GENERATION
    FROM
        ECOLI_DATA c
            JOIN
        relations p
        ON
            c.PARENT_ID = p.ID
)

SELECT
    COUNT(p.ID) as COUNT,
    p.GENERATION as GENERATION
FROM
    relations p
    LEFT JOIN
    relations c
ON
    p.ID = c.PARENT_ID
WHERE
    c.ID IS NULL
GROUP BY
    p.GENERATION