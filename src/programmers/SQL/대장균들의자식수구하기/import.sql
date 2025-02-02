SELECT
    parent.id,
    count(id) CHILD_COUNT
FROM
    ECOLI_DATA parent
LEFT JOIN
    ECOLI_DATA child
ON
    parent.id = child.PARENT_ID
group by
    parent.id