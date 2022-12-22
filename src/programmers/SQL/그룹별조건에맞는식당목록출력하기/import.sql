-- 코드를 입력하세요
SELECT
    sq.MEMBER_NAME,
    rr.REVIEW_TEXT,
    DATE_FORMAT(rr.REVIEW_DATE,"%Y-%m-%d") as REVIEW_DATE
FROM
    REST_REVIEW rr
        JOIN
    (
        SELECT
            mp.MEMBER_NAME, srr.MEMBER_ID
        FROM
            MEMBER_PROFILE mp
                JOIN
            REST_REVIEW srr
            ON
                    mp.MEMBER_ID = srr.MEMBER_ID
        GROUP BY
            srr.MEMBER_ID
        ORDER BY
            COUNT(REVIEW_ID) DESC
        LIMIT 1
    ) sq
    ON
            rr.MEMBER_ID = sq.MEMBER_ID
ORDER BY
    rr.REVIEW_DATE,rr.REVIEW_TEXT