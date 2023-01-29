# Write your MySQL query statement below
SELECT
    s.stock_name as stock_name,
    sum(
            CASE operation
                WHEN 'Sell' THEN s.price
                ELSE -s.price
                END
        ) as capital_gain_loss
FROM
    Stocks s
GROUP BY
    s.stock_name