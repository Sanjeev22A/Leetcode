# Write your MySQL query statement below
with temp_cte as(
    select id,visit_date,LAG(id) over win as id_prev,LAG(id,2) over win as id_prev_2,people,LAG(people) over win as people_prev,LAG(people,2) over win as people_prev_2 from stadium window win as (order by id)
),answer_cte as(
    select id,visit_date,people from temp_cte where people>=100 and people_prev>=100 and people_prev_2>=100 and id_prev=id-1 and id_prev_2=id-2 
),
temp_cte_2 as(
    select id,visit_date,LEAD(id) over win as id_prev,LEAD(id,2) over win as id_prev_2,people,LEAD(people) over win as people_prev,LEAD(people,2) over win as people_prev_2 from stadium window win as (order by id)
),answer_cte_2 as(
    select id,visit_date,people from temp_cte_2 where people>=100 and people_prev>=100 and people_prev_2>=100 and id_prev=id+1 and id_prev_2=id+2 
),
temp_cte_3 as(
    select id,visit_date,LEAD(id) over win as id_prev,LAG(id) over win as id_prev_2,people,LEAD(people) over win as people_prev,LAG(people) over win as people_prev_2 from stadium window win as (order by id)
),answer_cte_3 as(
    select id,visit_date,people from temp_cte_3 where people>=100 and people_prev>=100 and people_prev_2>=100 and id_prev=id+1 and id_prev_2=id-1 
)
#select * from answer_cte_3;
select * from answer_cte_2 union select * from answer_cte union select * from answer_cte_3 order by id;