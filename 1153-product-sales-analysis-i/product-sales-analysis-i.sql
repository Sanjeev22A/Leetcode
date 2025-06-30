# Write your MySQL query statement below
select B.product_name,A.year,A.price from sales A join product B on A.product_id=b.product_id;