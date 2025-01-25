SELECT
    he.EMP_NO,
    he.EMP_NAME,
    hg.GRADE,
    CASE
        WHEN GRADE = 'S' THEN he.SAL * 0.2
        WHEN GRADE = 'A' THEN he.SAL * 0.15
        WHEN GRADE = 'B' THEN he.SAL * 0.1
        ELSE 0
    END as BOUNS
FROM
    HR_DEPARTMENT hd
JOIN
    HR_EMPLOYEES he
ON
    hd.DEPT_ID = he.DEPT_ID
JOIN
    (
        SELECT
            EMP_NO,
            sum(SCORE) / 2 as score
            CASE
                WHEN score >= 96 THEN 'S'
                WHEN score >= 90 THEN 'A'
                WHEN socre >= 80 THEN 'B'
                ELSE 'C'
            END as GRADE
        FROM
            HR_GRADE
        GROUP BY
            EMP_NO
    ) hg
ON
    hd.EMP_NO = hg.EMP_NO
ORDER BY
    he.EMP_NO