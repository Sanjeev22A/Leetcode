# Write your MySQL query statement below
select A.project_id,Round(avg(B.experience_years),2) as average_years from project A join Employee B on A.employee_id=B.employee_id group by A.project_id;