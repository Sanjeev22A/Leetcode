# Write your MySQL query statement below
with confirmation_cte as(
    select user_id from confirmations where action="confirmed" 
),
user_cte as(
    select distinct(user_id),0 as confirmation_rate from Signups
),
confirmation_count_cte as(
    select user_id,count(*) as confirmation_count from confirmation_cte group by user_id
),
total_count_cte as(
    select user_id,count(*) as total_count from confirmations group by user_id
),
join_count_cte as(
    select B.user_id,A.confirmation_count,B.total_count from confirmation_count_cte  A right join total_count_cte B on A.user_id=B.user_id 
),
answer_cte as(
    select B.user_id,ROUND(A.confirmation_count/A.total_count,2)+B.confirmation_rate as confirmation_rate from join_count_cte A right join user_cte B on A.user_id=B.user_id
),
answer_null_removed_cte as(
    select user_id,
    case when confirmation_rate is null then 0
    else confirmation_rate 
    end as confirmation_rate
    from answer_cte
)
select * from answer_null_removed_cte;