SELECT
    fp.CATEGORY as CATEGORY,
    fp.PRICE as MAX_PRICE,
    fp.PRODUCT_NAME as PRODUCT_NAME
FROM
    FOOD_PRODUCT fp
        JOIN
    (
        SELECT
            fp.CATEGORY as CATEGORY,
            MAX(fp.PRICE) as MAX_PRICE
        FROM
            FOOD_PRODUCT fp
        WHERE
                fp.CATEGORY IN ('과자','국','김치','식용유')
        GROUP BY
            fp.CATEGORY
    ) t
    ON
            fp.CATEGORY = t.CATEGORY
WHERE
        fp.PRICE >= t.MAX_PRICE
ORDER BY
    fp.PRICE DESC;