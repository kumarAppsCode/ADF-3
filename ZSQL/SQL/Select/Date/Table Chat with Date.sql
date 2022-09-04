SELECT 
employee_number, 
  sum(case when to_char(ATTENDANCE_DATE,'MON')='JAN' then 1 else 0 end) JAN   
, sum(case when to_char(ATTENDANCE_DATE,'MON')='FEB' then 1 else 0 end) FEB   
, sum(case when to_char(ATTENDANCE_DATE,'MON')='MAR' then 1 else 0 end) MAR   
, sum(case when to_char(ATTENDANCE_DATE,'MON')='APR' then 1 else 0 end) APR   
, sum(case when to_char(ATTENDANCE_DATE,'MON')='MAY' then 1 else 0 end) MAY   
, sum(case when to_char(ATTENDANCE_DATE,'MON')='JUN' then 1 else 0 end) JUN   
, sum(case when to_char(ATTENDANCE_DATE,'MON')='JUL' then 1 else 0 end) JUL   
, sum(case when to_char(ATTENDANCE_DATE,'MON')='AUG' then 1 else 0 end) AUG
, sum(case when to_char(ATTENDANCE_DATE,'MON')='SEP' then 1 else 0 end) SEP
, sum(case when to_char(ATTENDANCE_DATE,'MON')='OCT' then 1 else 0 end) OCT
, sum(case when to_char(ATTENDANCE_DATE,'MON')='NOV' then 1 else 0 end) NOV   
, sum(case when to_char(ATTENDANCE_DATE,'MON')='DEC' then 1 else 0 end) DEC   
FROM
xxqia_time_attendance_daily 
where 
ATTENDANCE_DATE>='01-01-22' group by employee_number;        
