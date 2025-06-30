# Write your MySQL query statement below
#select A.product_id,A.product_name,B.sale_date from product A join sales B on (A.product_id=B.product_id #and (B.sale_date<'2019-01-01' or B.sale_date>'2019-03-31'));
select A.product_id,A.product_name from product A join sales B on A.product_id=B.product_id and B.sale_date>='2019-01-01' and B.sale_date<='2019-03-31'
except
select A.product_id,A.product_name from product A join sales B on (A.product_id=B.product_id and (B.sale_date<'2019-01-01' or B.sale_date>'2019-03-31'))
;