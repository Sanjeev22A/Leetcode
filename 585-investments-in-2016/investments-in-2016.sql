# Write your MySQL query statement below
with cte1 as(
    select tiv_2015 from Insurance group by tiv_2015 having count(*)>=2
),
cte2 as(
    select lat,lon from Insurance group by lat,lon having count(*)=1
)
select ROUND(sum(tiv_2016),2) as tiv_2016 from Insurance where tiv_2015 in (select tiv_2015 from cte1) and (lat,lon) in (select lat,lon from cte2);