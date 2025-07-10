# Write your MySQL query statement below
with approved_cte as(
    select * from transactions where state="approved"
),
total_amt_cte as (
    select DATE_FORMAT(trans_date,"%Y-%m") as month,country,count(*) as trans_count,sum(amount) as trans_total_amount from transactions group by country,month
),
approved_amt as (
    select DATE_FORMAT(trans_date,"%Y-%m") as month,country,count(*) as approved_count,sum(amount) as approved_total_amount from approved_cte group by country,month
),
temp_cte as(
    select A.month,A.country,A.trans_count,A.trans_total_amount,B.approved_count,B.approved_total_amount from total_amt_cte A left join approved_amt B on A.month=B.month and (A.country=B.country or(A.country is null and B.country is null) )
), temp_correct_cte as(
    select month,country,trans_count,trans_total_amount,
    case when approved_count is null then 0
    else approved_count
    end as approved_count,
    case when approved_total_amount is null then 0
    else approved_total_amount
    end as approved_total_amount
    from temp_cte
)
select * from temp_correct_cte;