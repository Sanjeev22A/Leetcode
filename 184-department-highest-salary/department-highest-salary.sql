# Write your MySQL query statement below


with deptTemp as (
    select B.name as Department,max(A.salary) as salary,B.id as deptId from employee A join department B on 
    A.departmentId=B.id group by B.id
)
select A.Department,B.name as Employee,A.salary from deptTemp A join Employee B on A.deptId=B.departmentId and A.salary=B.salary;