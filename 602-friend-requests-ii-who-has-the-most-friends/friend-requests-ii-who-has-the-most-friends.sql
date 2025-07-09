# Write your MySQL query statement below
with temp_cte as(
    select 
        accepter_id as requester_id,
        requester_id as accepter_id,
        accept_date 
        from RequestAccepted
),
create_union as(
    select * from RequestAccepted union select * from temp_cte
),count_each as(
    select requester_id as id,count(*) as num from create_union group by requester_id
),
counter as(
    select id,num,RANK() over (order by num desc) as my_rank from count_each
),final_ans as(
    select id,num from counter where my_rank=1
)


select * from final_ans;