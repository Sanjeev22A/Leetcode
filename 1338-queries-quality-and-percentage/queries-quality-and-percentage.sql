# Write your MySQL query statement below
#select query_name,result,position,rating,ROW_NUMBER() over (partition by query_name) from queries;
with temp1_cte as(
    select query_name,ROUND(avg(rating/position),2) as pos from queries group by query_name
),

temp_cte_3 as(
    select query_name,count(*) as c from queries where rating<3 group by query_name
),
temp_cte_4 as(
    select query_name,count(*) as d from queries group by query_name
),
ans_cte as(
    select A.query_name,A.pos as quality,coalesce(ROUND(C.c/D.d,4),0.00)*100 as poor_query_percentage from temp_cte_3 C right join temp_cte_4 D on C.query_name=D.query_name join temp1_cte A on A.query_name=D.query_name 
)
select * from ans_cte;

