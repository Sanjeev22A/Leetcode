# Write your MySQL query statement below
##This is a case of self-join
select A.name as Employee from employee A join employee B on A.managerId=B.id where A.salary>B.salary;