# Write your MySQL query statement below
with join_cte as(
    select A.id,A.name,B.id as orderId,B.customerId from customers A left join orders B on A.id=B.customerId
)

select name as Customers from join_cte where customerId is null;