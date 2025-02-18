WITH RENTABLE AS(
    SELECT
        cc.CAR_ID,
        cc.CAR_TYPE,
        FLOOR(cc.DAILY_FEE * 30 * ((100 - cdp.DISCOUNT_RATE) / 100)) FEE
    FROM
        CAR_RENTAL_COMPANY_CAR cc
    JOIN
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN cdp
        ON
            1=1
            AND cdp.CAR_TYPE = cc.CAR_TYPE
            AND cdp.DURATION_TYPE = '30일 이상'
    WHERE
        1=1
      AND cc.CAR_TYPE IN ('SUV', '세단')
      AND cc.CAR_ID NOT IN (
            SELECT
                DISTINCT(CAR_ID)
            FROM
                CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE
                1=1
              AND START_DATE <= DATE('2022-11-30')
              AND END_DATE >=DATE('2022-11-01')
    )
)

SELECT
    *
FROM
    RENTABLE
WHERE
    1=1
  AND FEE >= 500000
  AND FEE < 2000000
ORDER BY
    FEE DESC,
    CAR_TYPE ASC,
    CAR_ID DESC