SELECT * FROM (
SELECT 
AUTO_ID, EMP_ID, PUNCH_DATE_TIME, COUNT(*) AS L_COUNT
FROM igg_xx_employee_daily_attendance_raw_data
GROUP BY 
AUTO_ID,
EMP_ID,
PUNCH_DATE_TIME,
UNIT_ID)
WHERE L_COUNT>1;

--13217854

delete  from igg_xx_employee_daily_attendance_raw_data
where rowid not in
(select MIN(rowid) from igg_xx_employee_daily_attendance_raw_data 
GROUP BY 
AUTO_ID,
EMP_ID,
PUNCH_DATE_TIME,
UNIT_ID
);
