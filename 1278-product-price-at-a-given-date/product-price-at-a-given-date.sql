# Write your MySQL query statement below
with date_cte as (
    select * from products where change_date<="2019-08-16"
),
rem_cte as(
    select product_id,10 as new_price,"2019-08-16" as change_date from products where product_id not in (select product_id from date_cte)
),
final_cte as(
    select * from date_cte union select * from rem_cte
)
select product_id,price from (select product_id,new_price as price,DENSE_RANK() over (partition by product_id order by change_date desc ) as my_rank from final_cte) as temp where my_rank=1 ;