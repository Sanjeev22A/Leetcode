# Write your MySQL query statement below
#select id,num,LEAD(NUM,1,num+1) over (order by id) as prev,LAG(NUM,1,num-1) over (order by id) as next from logs;

select distinct(num) as ConsecutiveNums from (select id,num,LEAD(num,1,num+1) over (order by id) as prev,LAG(num,1,num-1) over (order by id) as next from logs) as temp where num=prev and num=next;
