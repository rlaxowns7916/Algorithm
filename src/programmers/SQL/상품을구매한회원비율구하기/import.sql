SELECT
    YEAR,
    MONTH,
    COUNT(DISTINCT(t.USER_ID)) as PUCHASED_USERS,
    ROUND((
              SELECT
                      COUNT(DISTINCT(t.USER_ID)) / COUNT(DISTINCT(ui.USER_ID))
              FROM
                  USER_INFO ui
              WHERE
                      YEAR(ui.JOINED) = "2021"
          ),1) as PUCHASED_RATIO
FROM
    USER_INFO ui
        JOIN
    (
        SELECT
            YEAR(os.SALES_DATE) as YEAR,
            MONTH(os.SALES_DATE) as MONTH,
            USER_ID
        FROM
            ONLINE_SALE os
    ) as t
    ON
            ui.USER_ID = t.USER_ID
WHERE
        YEAR(ui.JOINED) = "2021"
GROUP BY
    YEAR,MONTH
ORDER BY
    YEAR,MONTH