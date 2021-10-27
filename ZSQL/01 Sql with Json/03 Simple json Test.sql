create or replace PROCEDURE XX_GET_DATE (
    p_get_request_type      IN VARCHAR2,
    p_get_request_data      IN CLOB,
    p_get_data              OUT SYS_REFCURSOR
) 
AS
  l_json_text clob:='';
  l_json_count     PLS_INTEGER;
  l_members   WWV_FLOW_T_VARCHAR2;
  l_paths     APEX_T_VARCHAR2;
  l_exists    BOOLEAN;
  l_hdr_id  number;
  l_json_child_count     PLS_INTEGER;
  L_CURSOR     SYS_REFCURSOR;

  L_ERR     VARCHAR2(4000);

L_BUDGET_PLAN_HDR_ID number;
BEGIN 
--SYS_REFCURSOR
l_json_text:=p_get_request_data;
APEX_JSON.parse(l_json_text);
l_json_count := APEX_JSON.get_count(p_path => 'l_data');
--
--DBMS_OUTPUT.put_line('Total JSON Count:==>' || l_json_count);
--DBMS_OUTPUT.put_line('Total JSON Count 2:==>'|| apex_json.get_varchar2 ('l_data.IS_WHERE')); 
if(p_get_request_type='XXQIA_BUDGET_PLAN_HDR') then 
    if(apex_json.get_varchar2 ('l_data.IS_WHERE')='NO') THEN 
    DBMS_OUTPUT.put_line('NO-->'|| apex_json.get_varchar2 ('l_data.IS_WHERE'));
    DBMS_OUTPUT.put_line('NO-->'|| apex_json.get_varchar2 ('l_data.PRIMAY_KEY'));     
        OPEN L_CURSOR FOR
            SELECT 
            BUDGET_PLAN_HDR_ID
            , OBJECT_VERSION_NUMBER 
--            ,PLAN_ID, DEPTARTMENT_CODE, DEPTARTMENT_NAME, 
--            SECTION_NAME, COMMENTS, CREATION_DATE, CREATED_BY, 
--            LAST_UPDATE_DATE, LAST_UPDATED_BY, LAST_UPDATE_LOGIN, PLAN_NAME
            FROM XXQIA_BUDGET_PLAN_HDR;
    else
    DBMS_OUTPUT.put_line('YES==>'|| apex_json.get_varchar2 ('l_data.IS_WHERE'));
    DBMS_OUTPUT.put_line('YES==>'|| apex_json.get_varchar2 ('l_data.PRIMAY_KEY'));     
        OPEN L_CURSOR FOR
            SELECT 
            BUDGET_PLAN_HDR_ID
            , OBJECT_VERSION_NUMBER 
--            ,PLAN_ID, DEPTARTMENT_CODE, DEPTARTMENT_NAME, 
--            SECTION_NAME, COMMENTS, CREATION_DATE, CREATED_BY, 
--            LAST_UPDATE_DATE, LAST_UPDATED_BY, LAST_UPDATE_LOGIN, PLAN_NAME
            FROM XXQIA_BUDGET_PLAN_HDR
            WHERE BUDGET_PLAN_HDR_ID=apex_json.get_varchar2 ('l_data.PRIMAY_KEY');
    end if;
      
      
p_get_data := L_CURSOR;
end if;

EXCEPTION WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE(sqlerrm);
L_ERR:=sqlerrm;
OPEN L_CURSOR FOR
        SELECT 
        L_ERR AS BUDGET_PLAN_HDR_ID
--        , -1 AS OBJECT_VERSION_NUMBER, 
--        -1 AS PLAN_ID, -1 AS DEPTARTMENT_CODE, -1 AS DEPTARTMENT_NAME, 
--        -1 AS SECTION_NAME, -1 AS COMMENTS 
        FROM DUAL;
p_get_data := L_CURSOR;
END XX_GET_DATE;
