# Write your MySQL query statement below
with id_cte as (
    select id from seat
),
ans_cte as(
    select
    case 
        when id%2=1 and (id+1) in (select * from id_cte) then id+1

        else 
        case when id%2=0 then id-1
        else id
        end
    end as id,student from seat
)
select * from ans_cte order by id;