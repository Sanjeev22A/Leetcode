# Write your MySQL query statement below
with user_cte as (
    select user_id,count(*) as num from movierating group by user_id
),
max_users as(
    select user_id,DENSE_RANK() over (order by num desc) as my_rank from user_cte
),
max_user as(
    select user_id from max_users where my_rank=1
),
max_user_name as(
    select A.name,DENSE_RANK() over (order by A.name) as my_rank from users a join max_user b on A.user_id=B.user_id 
),
max_user_name_1 as (
    select name as results from max_user_name where my_rank=1
),
movie_cte as(
    select movie_id,ROUND(sum(rating)/count(*),2) as num from movierating where date_format(created_at,"%Y")='2020' and date_format(created_at,"%m")='02' group by movie_id
),
max_movies as(
    select movie_id,dense_rank() over (order by num desc) as my_rank from movie_cte
),
max_movie as(
    select movie_id from max_movies where my_rank=1
),
max_movie_name as(
    select A.title,dense_rank() over (order by A.title) as my_rank from movies a join max_movie b on A.movie_id=B.movie_id
),
max_movie_name_1 as(
    select title as results from max_movie_name where my_rank=1
),
result_cte as(
    select * from max_user_name_1 union all select * from max_movie_name_1
)
select * from result_cte;