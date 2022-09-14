SELECT
    REQUEST_NUMBER,  
    to_char(to_date(replace(replace(EDU_LAST_PAID_DATE,'T',' '),'Z',''),'RRRR-MM-DD HH24:MI:SS') ,'DD-MON-YYYY') as EDU_LAST_PAID_DATE,
--    to_char(to_date(EDU_DATE_OF_BIRTH,'RRRR-MM-DD'),'DD-MM-YYYY') as EDU_DATE_OF_BIRTH,
    to_char(to_date(EDU_DATE_OF_BIRTH,'RRRR-MM-DD') ,'DD-MON-YYYY')as EDU_DATE_OF_BIRTH
FROM ***L_V
where
    ROWNUM=1
    AND REQUEST_ID=000;
