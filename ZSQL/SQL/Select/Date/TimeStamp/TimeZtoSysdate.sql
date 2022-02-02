to_date(substr(request_date, 1, instr(request_date, 'T')-1), 'YYYY-MM-dd')  as request_date,
