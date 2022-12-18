SELECT j.FLAVOR FROM FIRST_HALF fh
                         JOIN
                     (
                         SELECT
                             FLAVOR, SUM(TOTAL_ORDER) as JULY_ORDER
                         FROM
                             JULY
                         GROUP BY
                             FLAVOR
                     ) as j ON j.FLAVOR = fh.FLAVOR
ORDER BY fh.TOTAL_ORDER+j.JULY_ORDER DESC
LIMIT 3;