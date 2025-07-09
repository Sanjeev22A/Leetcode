# Write your MySQL query statement below
with count_cte as(
    select count(distinct(product_key)) as cnt from product
)
select customer_id from (select customer_id,count(distinct(product_key)) as cnt from customer group by customer_id) as temp where cnt=(select cnt from count_cte );