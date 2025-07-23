# Write your MySQL query statement below
with temp_cte as(
    select A.visited_on,

    (select sum(amount) from customer where visited_on between date_sub(A.visited_on,interval 6 day) and A.visited_on) as amount,
    (select ROUND(sum(amount)/7,2) from customer where visited_on between date_sub(A.visited_on,interval 6 day) and A.visited_on) as average_amount
    from customer A 

),first_date as(
    select min(visited_on) as first_date from customer
)

select distinct(visited_on),amount,average_amount from temp_cte where visited_on>=date_add((select * from first_date),interval 6 day);