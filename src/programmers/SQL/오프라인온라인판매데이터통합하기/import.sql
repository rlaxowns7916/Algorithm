SELECT
    DATE_FORMAT(SALES_DATE,"%Y-%m-%d") AS SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM
    (
        (SELECT
             USER_ID,
             PRODUCT_ID,
             SALES_AMOUNT,
             SALES_DATE
         FROM
             ONLINE_SALE
         WHERE DATE_FORMAT(SALES_DATE,"%Y%m") = "202203"
        )
        UNION ALL
        (SELECT
             NULL as USER_ID,
             PRODUCT_ID,
             SALES_AMOUNT,
             SALES_DATE
         FROM
             OFFLINE_SALE
         WHERE DATE_FORMAT(SALES_DATE,"%Y%m") = "202203"
        )
    ) t
ORDER BY SALES_DATE,PRODUCT_ID,USER_ID;