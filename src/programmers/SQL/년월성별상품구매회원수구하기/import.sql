SELECT
    YEAR(os.SALES_DATE) as YEAR,
    MONTH(os.SALES_DATE) as MONTH,
    ui.GENDER as GENDER,
    count(distinct os.USER_ID) as USERS
FROM
    USER_INFO ui
        JOIN
    ONLINE_SALE os
    ON
            ui.USER_ID = os.USER_ID
GROUP BY
    YEAR(os.SALES_DATE),MONTH(os.SALES_DATE),ui.GENDER
HAVING
    ui.GENDER is not null
ORDER BY YEAR,MONTH,GENDER