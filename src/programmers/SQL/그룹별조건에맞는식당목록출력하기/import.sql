WITH REVIEW_COUNTS AS (
    SELECT
        MEMBER_ID,
        COUNT(REVIEW_ID) AS review_count
    FROM
        REST_REVIEW
    GROUP BY
        MEMBER_ID
),
    MAX_REVIEW_COUNT AS (
        SELECT
            MAX(review_count) AS max_count
        FROM
            REVIEW_COUNTS
)

SELECT
    mp.MEMBER_NAME,
    rr.REVIEW_TEXT,
    DATE_FORMAT(rr.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE mp
         JOIN REST_REVIEW rr ON mp.MEMBER_ID = rr.MEMBER_ID
         JOIN REVIEW_COUNTS rc ON mp.MEMBER_ID = rc.MEMBER_ID
         JOIN MAX_REVIEW_COUNT mrc ON rc.review_count = mrc.max_count
ORDER BY rr.REVIEW_DATE, rr.REVIEW_TEXT;