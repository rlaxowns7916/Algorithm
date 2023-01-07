-- 코드를 입력하세요
SELECT
    *
FROM
    PLACES op
WHERE
        op.HOST_ID
        IN (
            SELECT
                ip.HOST_ID
            FROM
                PLACES ip
            GROUP BY
                ip.HOST_ID
            HAVING
                    COUNT(*) > 1
        );