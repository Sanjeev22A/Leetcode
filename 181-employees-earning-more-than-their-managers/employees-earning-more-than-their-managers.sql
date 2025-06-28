# Write your MySQL query statement below
##This is a case of self-join
select A.name as Employee from employee A,employee B where A.managerId=B.id and A.salary>B.salary;