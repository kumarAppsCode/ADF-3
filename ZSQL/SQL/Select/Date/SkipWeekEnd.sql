  CREATE OR REPLACE FORCE EDITIONABLE VIEW "XXQIA"."XXQIA_SUBMIT_PERMISSION_V" ("REQUEST_ID", "REQUEST_TYPE", "PERSON_ID", "REQUEST_DATE", "REQUEST_STATUS", "VBCS_INSTANCE_ID", "PERMISSION_DATE", "PERMISSION_REQ_DATE", "LSYSDATE", "AUTO_REJECT_MAIL_DATE", "REMAINDER_MAIL_DATE") AS 
  SELECT
    rd.request_id,
    rd.request_type,
    rd.person_id,
    rd.REQUEST_DATE,
    rd.request_status                                              AS request_status,
    rd.vbcs_instance_id                                            AS vbcs_instance_id,
    to_date(substr(rd.request_data.per_date, 0, 10), 'YYYY-mm-dd') AS permission_date,
    to_date(to_char(rd.REQUEST_DATE, 'YYYY-MM-DD'), 'YYYY-MM-DD') AS  permission_req_date, 
    sysdate                                                        AS lsysdate,
--    CASE 
--    WHEN 
--    TO_CHAR(rd.REQUEST_DATE, 'DY') IN ('THU') AND TO_CHAR(rd.REQUEST_DATE+3, 'DY') IN ('SUN') THEN to_date(to_char(rd.REQUEST_DATE, 'YYYY-MM-DD'), 'YYYY-MM-DD')+4
--    ELSE to_date(to_char(rd.REQUEST_DATE, 'YYYY-MM-DD'), 'YYYY-MM-DD')+2
--    END AS AUTO_REJECT_MAIL_DATE,
--    CASE 
--    WHEN 
--    TO_CHAR(rd.REQUEST_DATE, 'DY') IN ('THU') AND TO_CHAR(rd.REQUEST_DATE+3, 'DY') IN ('SUN') THEN to_date(to_char(rd.REQUEST_DATE, 'YYYY-MM-DD'), 'YYYY-MM-DD')+3
--    ELSE to_date(to_char(rd.REQUEST_DATE, 'YYYY-MM-DD'), 'YYYY-MM-DD')+1
--    END AS REMAINDER_MAIL_DATE
        to_char(rd.REQUEST_DATE + 72/24, 'DD-MM-YYYY') AS AUTO_REJECT_MAIL_DATE,
        to_char(rd.REQUEST_DATE + 48/24, 'DD-MM-YYYY') AS REMAINDER_MAIL_DATE        
FROM
    xxfs_request_details rd
WHERE
        rd.request_type = 'SUBMIT_PERMISSION'
    AND request_status = 'Pending'
--    and REQUEST_ID=79
;

