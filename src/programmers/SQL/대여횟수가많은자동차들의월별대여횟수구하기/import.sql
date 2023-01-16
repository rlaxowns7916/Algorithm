-- 코드를 입력하세요
SELECT
    MONTH(crh.start_date) as MONTH,
    crh.CAR_ID as CAR_ID,
    COUNT(crh.HISTORY_ID) as RECORDS
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY crh
WHERE
        crh.CAR_ID IN
        (
            SELECT
                crh.CAR_ID
            FROM
                CAR_RENTAL_COMPANY_RENTAL_HISTORY crh
            WHERE
                    crh.START_DATE >= '2022-08-01' AND
                    crh.START_DATE < '2022-11-01'
            GROUP BY
                CAR_ID
            HAVING
                    COUNT(crh.history_id) >= 5
        )
  AND
    (crh.START_DATE >= '2022-08-01' AND crh.START_DATE < '2022-11-01')
GROUP BY
    MONTH(crh.start_date),crh.CAR_ID
ORDER BY
    MONTH, CAR_ID DESC