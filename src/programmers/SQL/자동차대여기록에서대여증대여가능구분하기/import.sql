SELECT
    crs1.CAR_ID,
    IFNULL(crs2.AVAILABILITY, '대여 가능')
FROM
    (SELECT DISTINCT(CAR_ID) FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) crs1
LEFT JOIN
    (
        SELECT
            CAR_ID,
            '대여중' AVAILABILITY
        FROM
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE
            1=1
            AND '2022-10-16' between START_DATE AND END_DATE
    ) crs2
ON
    crs1.CAR_ID = crs2.CAR_ID
ORDER BY
    crs1.CAR_ID desc