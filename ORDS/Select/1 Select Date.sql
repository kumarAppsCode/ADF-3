SELECT REQUEST_DATE,  to_date('2022-02-08', 'YYYY-mm-dd') as ddate FROM xxfs_request_details
WHERE
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
