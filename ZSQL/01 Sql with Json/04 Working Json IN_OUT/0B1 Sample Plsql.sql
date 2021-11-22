create or replace PROCEDURE XX_POST_INSERT_BUDGET_PLAN (
    p_request_data      IN BLOB) 
AS
   l_object   json_object_t; 
L_CURSOR SYS_REFCURSOR;
L_ERR VARCHAR2(2000);
lvalue varchar2(120);
lclob CLOB;
BEGIN 

--   l_object := json_object_t.parse ('{"ABC":"Elvis"}'); 

--lclob:=CONCAT(CONCAT('''', p_request_data), '''');
l_object := json_object_t.parse (p_request_data); 

--   DBMS_OUTPUT.put_line (l_object.get_string ('ABC')); 
    lvalue:=l_object.get_string ('ABC');   
OPEN L_CURSOR FOR
        SELECT 
         lvalue as val
        FROM dual;
 
  APEX_JSON.open_object;
  APEX_JSON.write (L_CURSOR);
--    APEX_JSON.write ( 'rws', L_CURSOR );
  APEX_JSON.close_object;
--  p_get_data := APEX_JSON.get_clob_output;

--
EXCEPTION 
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE(sqlerrm);
L_ERR:=sqlerrm;
  APEX_JSON.open_object;
--  APEX_JSON.write (apex_json.get_varchar2 ('planname'));
    APEX_JSON.write ( 'rws', L_ERR );
  APEX_JSON.close_object;
END XX_POST_INSERT_BUDGET_PLAN;
