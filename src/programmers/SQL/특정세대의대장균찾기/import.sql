WITH RECURSIVE relations AS(
    SELECT
        ID,
        PARENT_ID,
        1 AS GENERATIONS
    FROM
        ECOLI_DATA
    WHERE
        PARENT_ID IS NULL

    UNION ALL

    SELECT
        c.ID,
        c.PARENT_ID,
        p.GENERATIONS + 1 AS GENERATIONS
    FROM
        ECOLI_DATA c
            JOIN
        relations p
        ON
            c.PARENT_ID = p.ID

)

SELECT
    ID
FROM
    relations
WHERE
    GENERATIONS = 3
