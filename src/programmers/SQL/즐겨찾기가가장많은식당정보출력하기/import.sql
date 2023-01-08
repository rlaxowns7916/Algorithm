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
            iri.FOOD_TYPE as FOOD_TYPE,
            MAX(iri.FAVORITES) as FAVORITES
        FROM
            REST_INFO iri
        GROUP BY
            iri.FOOD_TYPE
    )t
    ON
                ori.FOOD_TYPE = t.FOOD_TYPE
            AND ori.FAVORITES = t.FAVORITES
ORDER BY
    FOOD_TYPE DESC