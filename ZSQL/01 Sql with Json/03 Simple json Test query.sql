set SERVEROUTPUT ON;
DECLARE
  P_GET_REQUEST_TYPE VARCHAR2(200);
  P_GET_REQUEST_DATA CLOB;
  P_GET_DATA SYS_REFCURSOR;
L_BUDGET_PLAN_HDR_ID number;
L_OBJ number;
BEGIN
  P_GET_REQUEST_TYPE := 'XXQIA_BUDGET_PLAN_HDR';
  P_GET_REQUEST_DATA := 
'{
    "l_data":{
            "IS_WHERE": "YES",
			"PRIMAY_KEY":10
        }
    
}';

  XX_GET_DATE(
    P_GET_REQUEST_TYPE => P_GET_REQUEST_TYPE,
    P_GET_REQUEST_DATA => P_GET_REQUEST_DATA,
    P_GET_DATA => P_GET_DATA
  );

    LOOP
        FETCH P_GET_DATA INTO L_BUDGET_PLAN_HDR_ID, L_OBJ;
        EXIT WHEN P_GET_DATA%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('=='||L_BUDGET_PLAN_HDR_ID);
        DBMS_OUTPUT.PUT_LINE('=='||L_OBJ);
      END LOOP;
END;
