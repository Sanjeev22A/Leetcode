-- Write your MySQL query statement below
WITH unbanned_cte AS (
    SELECT users_id FROM Users WHERE banned = 'No'
),
state_filter_cte AS (
    SELECT 
        A.id,
        A.request_at,
        A.client_id,
        A.driver_id,
        A.status
    FROM 
        Trips A
    WHERE 
        A.request_at BETWEEN '2013-10-01' AND '2013-10-03'
        AND (
            (
                (A.client_id  IN (SELECT * FROM unbanned_cte) and A.driver_id  IN (SELECT * FROM unbanned_cte))
                AND A.status IN ('cancelled_by_driver', 'cancelled_by_client','completed')
            )
            
        )
),
state_filter_1_cte AS (
    SELECT * FROM state_filter_cte WHERE status <> 'completed'
),
non_completed_count_cte AS (
    SELECT request_at, COUNT(*) AS failed FROM state_filter_1_cte GROUP BY request_at
),
total_count_cte AS (
    SELECT request_at, COUNT(*) AS total FROM state_filter_cte GROUP BY request_at
),
ans_cte AS (
    SELECT 
        B.request_at AS Day,
        ROUND(COALESCE(A.failed, 0) / B.total, 2) AS `Cancellation Rate`
    FROM 
        non_completed_count_cte A 
        RIGHT JOIN total_count_cte B ON A.request_at = B.request_at
)
SELECT * FROM ans_cte;
