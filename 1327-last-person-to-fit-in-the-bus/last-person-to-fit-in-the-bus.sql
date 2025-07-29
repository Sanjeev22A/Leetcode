# Write your MySQL query statement below
#select person_name from (select person_name,weight,sum(weight) over (order by turn) as cum_sum,turn from queue order by turn) as temp1 where cum_sum<=1000 order by cum_sum desc limit 1;
with temp_cte as(
    select person_id,person_name,sum(weight) over (order by turn rows between unbounded preceding and current row) as weight from queue order by turn
),
temp_cte_2 as(
    select person_name,rank() over(order by weight desc) as my_rank from temp_cte where weight<=1000
)
select person_name from temp_cte_2 where my_rank=1;