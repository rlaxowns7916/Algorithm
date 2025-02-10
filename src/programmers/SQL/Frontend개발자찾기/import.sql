SELECT
    d.ID,
    d.EMAIL,
    d.FIRST_NAME,
    d.LAST_NAME
FROM
    DEVELOPERS d
WHERE
    EXISTS(
        SELECT
            1
        FROM
            SKILLCODES sc
        WHERE
            sc.CATEGORY = 'Front End'
          AND d.SKILL_CODE & sc.CODE != 0
    )
ORDER BY
    d.ID