SELECT  
    rd.request_id as request_id,
    rd.object_version_num as object_version_num,
    rd.iteration_num as iteration_num,
    rd.request_type_id as request_type_id,
    rd.request_type as request_type,
    rd.requester_id as requester_id,
    rd.person_id as person_id,
    to_char(rd.REQUEST_DATE, 'yyyy-mm-dd') as request_date,
    INITCAP(to_char(rd.request_date, 'dd-MON-yyyy')) as request_date,
    rd.REQUEST_DATA "{}ldata",
    rd.description as description,
    rd.request_status as request_status,
    rd.created_by as created_by,
    rd.creation_date as creation_date,
    rd.last_updated_by as last_updated_by,
    rd.last_update_date as last_update_date,
    rd.last_update_login as last_update_login,
    rd.request_number as request_number,
    lk.LOOKUP_VALUE_NAME as request_type_disp,
    rd.request_number as request_number,
    logemp.person_number AS login_person_number, 
    logemp.full_name AS login_full_name, 
    logemp.email_address AS login_email_address, 
    logemp.user_id AS login_user_id, 
    logemp.business_unit AS login_business_unit,
    emp.person_number AS requester_person_number, 
    emp.full_name AS requester_full_name, 
    emp.email_address AS requester_email_address, 
    emp.user_id AS requester_user_id, 
    emp.business_unit AS requester_business_unit
FROM xxfs_request_details rd, xxfnd_lookup_v lk, EMPLOYEE_LIST_V logemp, EMPLOYEE_LIST_V emp
where 
rd.request_type= lk.LOOKUP_VALUE_CODE
and lk.LOOKUP_TYPE_CODE='SERVICE_REQUEST'
and logemp.PERSON_ID=rd.REQUESTER_ID
and emp.PERSON_ID=rd.PERSON_ID
and rd.request_id=rd.request_id+0
and rd.request_id=DECODE(:prequest_id, 0, rd.request_id, null, rd.request_id, :prequest_id)
and 
(UPPER (lk.LOOKUP_VALUE_NAME) LIKE '%' || UPPER (:lrequest_type) || '%' OR :lrequest_type IS NULL) OR 
UPPER(:lrequest_type)= UPPER('Search') OR UPPER(:lrequest_type)= UPPER('undefined') 
and 
(
REQUEST_DATE  BETWEEN 
--to_date('2022-02-08', 'YYYY-mm-dd') and  to_date('2022-02-08', 'YYYY-mm-dd')
DECODE(:lrequest_date,  'undefined'	 , REQUEST_DATE,
                        'Search'	 , REQUEST_DATE,
                         NULL, 		  to_date('1951-01-01', 'YYYY-mm-dd'),
                                      to_date(:lrequest_date, 'YYYY-mm-dd')) 
AND
DECODE(:lrequest_date,  'undefined'	 , REQUEST_DATE,
                        'Search'	 , REQUEST_DATE,
                         NULL        ,to_date('4712-01-01', 'YYYY-mm-dd'),
                                      to_date(:lrequest_date, 'YYYY-mm-dd')) 
)
--and req.PERSON_ID=1247
