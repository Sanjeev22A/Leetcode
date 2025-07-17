# Write your MySQL query statement below
with stock_buy_cte as (
    select stock_name,operation,sum(price) as money from stocks group by stock_name,operation having operation="Buy"
),
stock_sell_cte as (
    select stock_name,operation,sum(price) as money from stocks group by stock_name,operation having operation="Sell"
),
stock_diff as(
    select A.stock_name,A.money-B.money as capital_gain_loss from stock_sell_cte A join stock_buy_cte B on A.stock_name=B.stock_name
)

select * from stock_diff;