# Write your MySQL query statement below
with player_count as (
    select player_id,event_date,LAG(event_date,1) over (partition by player_id order by event_date) as prev_date,min(event_date) over (partition by player_id order by event_date) as min_date from activity
),
count_next_log_in as(
    select count(*) from player_count where prev_date=min_date and datediff(event_date,prev_date)=1
),
count_total as(
    select count(distinct(player_id)) from activity
)
select round((select * from count_next_log_in)/(select * from count_total),2) as fraction;