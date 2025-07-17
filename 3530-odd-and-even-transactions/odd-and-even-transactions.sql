-- Write your PostgreSQL query statement below
/* Write your PL/SQL query statement below */

with transaction_odd_cte as(
    select transaction_date,sum(amount) as odd_amount from transactions where amount%2=1 group by transaction_date
),
transaction_even_cte as(
    select transaction_date,sum(amount) as even_amount from transactions where amount%2=0 group by transaction_date
),
transaction_cte as(
    select 
    case when A.transaction_date is null then B.transaction_date
    else A.transaction_date
    end as transaction_date,
    case when A.odd_amount is null then 0
    else A.odd_amount
    end as odd_sum,
    case when B.even_amount is null then 0
    else B.even_amount
    end as even_sum
    from transaction_odd_cte A full outer join transaction_even_cte B on A.transaction_date=B.transaction_date
)

select * from transaction_cte;