-- 코드를 입력하세요
SELECT
    t.HISTORY_ID,
    (
        CASE
            WHEN t.RENTAL_RANGE < 7 THEN t.DAILY_FEE * t.RENTAL_RANGE
            ELSE
                (
                        t.RENTAL_RANGE * t.DAILY_FEE *
                        (
                            SELECT
                                    1 - (it.DISCOUNT_RATE * 0.01)
                            FROM
                                (
                                    SELECT
                                        LEFT(DISCOUNT_RATE,LENGTH(DISCOUNT_RATE-1)) as DISCOUNT_RATE
                                    FROM
                                        CAR_RENTAL_COMPANY_DISCOUNT_PLAN cdp
                                    WHERE
                                            cdp.CAR_TYPE = t.CAR_TYPE
                                      AND
                                            cdp.DURATION_TYPE =
                                            (
                                                CASE
                                                    WHEN t.RENTAL_RANGE < 30 THEN '7일 이상'
                                                    WHEN t.RENTAL_RANGE < 90 THEN '30일 이상'
                                                    ELSE '90일 이상'
                                                    END
                                                )
                                ) as it
                        )
                    )
            END
        ) as FEE

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
ORDER BY FEE DESC, HISTORY_ID DESC