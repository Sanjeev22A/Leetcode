# Write your MySQL query statement below
with join_cte as(
    select A.buyer_id,B.join_date,A.order_id from orders A join Users B on A.buyer_id=B.user_id and YEAR(A.order_date)=2019
),
count_cte as(
    select buyer_id,join_date,count(*) as orders_in_2019 from join_cte group by buyer_id
),
buyer_present as(
    select buyer_id from count_cte
),
add_rest as (
    select user_id,join_date,0 as orders_in_2019 from users where user_id not in (select buyer_id from buyer_present)
),
final_ans as(
    select * from count_cte union select * from add_rest
)

select * from final_ans;