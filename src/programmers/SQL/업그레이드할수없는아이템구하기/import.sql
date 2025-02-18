SELECT
    ii.ITEM_ID,
    ii.ITEM_NAME,
    ii.RARITY
FROM
    ITEM_TREE it1
        JOIN
    ITEM_INFO ii
    ON
        it1.ITEM_ID = ii.ITEM_ID
        LEFT JOIN
    ITEM_TREE it2
    ON
        it1.ITEM_ID = it2.PARENT_ITEM_ID
WHERE
    it2.ITEM_ID IS NULL
group by
    ii.ITEM_ID
having
    count(it2.ITEM_ID) = 0
order by
    ii.ITEM_ID DESC