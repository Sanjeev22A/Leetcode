# Write your MySQL query statement below
with customer_order_count as(
    select customer_number,count(order_number) as order_count from orders group by customer_number order by order_count desc
)


select customer_number from customer_order_count limit 1;