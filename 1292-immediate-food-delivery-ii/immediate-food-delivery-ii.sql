# Write your MySQL query statement below
with order_date as(
    select customer_id,min(order_date) as od from delivery group by customer_id
),
customer_percentage as(
    select A.customer_id,A.od,B.customer_pref_delivery_date from order_date A join delivery B on A.customer_id=B.customer_id and A.od=B.order_date and A.od=B.customer_pref_delivery_date
)
select ROUND(
    ((select count(*) from customer_percentage)*100/(select count(distinct(customer_id)) from delivery)),2
) as immediate_percentage;