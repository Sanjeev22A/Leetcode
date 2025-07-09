# Write your MySQL query statement below
#select p_id as id,count(*) from Tree group by p_id;
with count_cte as (
    select p_id as id,count(*) as count from Tree group by p_id
)
select id,
    case 
    when p_id is null then "Root"
    else
        case 
        when id in (select id from count_cte) then "Inner"
        else "Leaf"
        end
    end as type from Tree;
