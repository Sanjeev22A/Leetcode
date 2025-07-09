# Write your MySQL query statement below
with count_cte as(
    select product_id,year,min(year) over (partition by product_id) as first_year,quantity,price from sales
)
select product_id,first_year,quantity,price from count_cte where year=first_year;