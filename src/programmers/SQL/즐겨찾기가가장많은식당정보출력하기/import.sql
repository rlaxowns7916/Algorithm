-- 코드를 입력하세요
SELECT
    ori.FOOD_TYPE,
    ori.REST_ID,
    ori.REST_NAME,
    ori.FAVORITES
FROM
    REST_INFO ori
        JOIN
    (
        SELECT
            REST_ID,
            FOOD_TYPE,
            RANK() OVER(PARTITION BY iri.FOOD_TYPE ORDER BY iri.FAVORITES DESC) as RANKING
        FROM
            REST_INFO iri
    ) t
    ON
            ori.REST_ID = t.REST_ID
WHERE
        RANKING = 1
ORDER BY
    FOOD_TYPE DESC