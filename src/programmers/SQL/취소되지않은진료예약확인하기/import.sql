SELECT
    a.APNT_NO,
    p.PT_NAME,
    p.PT_NO,
    d.MCDP_CD,
    d.DR_NAME,
    a.APNT_YMD
FROM
    PATIENT p
        JOIN
    APPOINTMENT a
        JOIN
    DOCTOR d
    ON
                a.MDDR_ID = d.DR_ID AND p.PT_NO = a.PT_NO
WHERE
        DATE_FORMAT(a.APNT_YMD,"%Y%m%d") = "20220413"
  AND
        a.APNT_CNCL_YN = "N" AND a.APNT_CNCL_YMD IS NULL
  AND
        a.MCDP_CD = "CS"
ORDER BY a.APNT_YMD;