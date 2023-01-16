SELECT
    HISTORY_ID,
    ROUND((
              CASE
                  WHEN RENTAL_RANGE < 7 THEN 1
                  ELSE 1 - (DISCOUNT_RATE *0.01)
                  END
              ) * RENTAL_RANGE * DAILY_FEE) as FEE
FROM
    (
        SELECT
            crh.HISTORY_ID,
            c.DAILY_FEE,
            c.CAR_TYPE,
            TIMESTAMPDIFF(DAY,crh.START_DATE,crh.END_DATE) +1 as RENTAL_RANGE
        FROM
            CAR_RENTAL_COMPANY_CAR as c
                JOIN
            CAR_RENTAL_COMPANY_RENTAL_HISTORY as crh
            ON
                    c.CAR_ID = crh.CAR_ID
        WHERE
                c.CAR_TYPE = '트럭'
    ) t
        LEFT JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN cdp
    ON
                cdp.CAR_TYPE = t.CAR_TYPE
            AND (
                    CASE
                        WHEN t.RENTAL_RANGE < 30 THEN '7일 이상'
                        WHEN t.RENTAL_RANGE < 90 THEN '30일 이상'
                        ELSE '90일 이상'
                        END
                    ) = cdp.DURATION_TYPE
ORDER BY FEE DESC, HISTORY_ID DESC