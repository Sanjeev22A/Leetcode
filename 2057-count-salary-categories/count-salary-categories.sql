# Write your MySQL query statement below
with count_table as(
    select account_id,income,
    CASE
    when income<20000 then "Low Salary"
    else
        case
        when income>=20000 and income<=50000 then "Average Salary"
        else "High Salary"
        end
    end as salary_type
    from accounts
),
sal_type as(
    select "High Salary" as category UNION select "Average Salary" as category UNION select "Low Salary" as category
),
union_table as(
    select B.category,A.income,A.account_id from count_table A right join sal_type B on B.category=A.salary_type
)
select category,count(account_id)  as accounts_count from union_table group by category order by count(account_id) desc;