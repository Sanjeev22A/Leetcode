-- Write your PostgreSQL query statement below
with student_first_date_cte as(
    select student_id,subject,min(exam_date) as exam_date from scores group by student_id,subject
),
student_first_score_cte as(
    select A.student_id,A.subject,A.exam_date,B.score from student_first_date_cte A join scores B on A.student_id=B.student_id and A.subject=B.subject and A.exam_date=B.exam_date
),
student_last_date_cte as(
    select student_id,subject,max(exam_date) as exam_date from scores group by student_id,subject
),
student_last_score_cte as(
    select A.student_id,A.subject,A.exam_date,B.score from student_last_date_cte A join scores B on A.student_id=B.student_id and A.subject=B.subject and A.exam_date=B.exam_date
),
student_diff_cte as(
    select A.student_id,A.subject,A.score  as first_score,B.score as latest_score from student_first_score_cte A join student_last_score_cte B on A.student_id=B.student_id and A.exam_date<>B.exam_date and A.subject=B.subject and A.score<B.score order by A.student_id,A.subject asc
)
select * from student_diff_cte;