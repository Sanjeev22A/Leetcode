# Write your MySQL query statement below
with class_count as(
    select class,count(student) as countStud from courses group by class having countStud>=5
)
select class from class_count;

#select class from class_count limit 1;