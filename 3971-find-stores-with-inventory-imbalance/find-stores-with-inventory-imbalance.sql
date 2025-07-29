# Write your MySQL query statement below

with expensive_cte as(
    select store_id,product_name,quantity,price,rank() over (partition by store_id order by price desc) as my_rank from inventory
),
product_count_cte as(
    select store_id,count(*) as number from inventory group by store_id
),
stores_cte as(
    select store_id from product_count_cte where number>=3
),
cheap_cte as(
    select store_id,product_name,quantity,price,rank() over (partition by store_id order by price) as my_rank from inventory
),
expensive_cache_cte as(
    select * from expensive_cte where my_rank=1
),
cheap_cache_cte as(
    select * from cheap_cte where my_rank=1
),
temp_cte as(
    select A.store_id,A.store_name,A.location,B.product_name as most_exp_product,C.product_name as cheapest_product,ROUND(C.quantity/B.quantity,2) as imbalance_ratio from stores A join expensive_cache_cte B on A.store_id=B.store_id join cheap_cache_cte C on A.store_id=C.store_id join stores_cte D on A.store_id=D.store_id
),
ans_cte as(
    select * from temp_cte where imbalance_ratio>1 order by imbalance_ratio desc,store_name asc
)
select * from ans_cte;