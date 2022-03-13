create or replace PACKAGE BODY ps_community_master_pkg
IS
   CURSOR cur_data (p_data BLOB)
   IS
      SELECT community_id
            ,object_version_no
            ,community_code
            ,community_name
            ,community_name_ar
            ,master_developer_id
            ,master_developer
            ,master_developer_ar
            ,master_community_id
            ,sub_community_id
            ,location_id
            ,district_id
            ,state_id
            ,country_code
            ,sma_code
            ,code
            ,old_id
            ,bu_id
            ,created_by
            ,creation_date
            ,last_updated_by
            ,last_update_date
            ,last_update_login
        FROM json_table ( p_data FORMAT JSON, '$'
        COLUMNS (community_id NUMBER PATH '$.community_id'
                ,object_version_no NUMBER PATH '$.object_version_no'
                ,community_code VARCHAR2 PATH '$.community_code'
                ,community_name VARCHAR2 PATH '$.community_name'
                ,community_name_ar VARCHAR2 PATH '$.community_name_ar'
                ,master_developer_id NUMBER PATH '$.master_developer_id'
                ,master_developer VARCHAR2 PATH '$.master_developer'
                ,master_developer_ar VARCHAR2 PATH '$.master_developer_ar'
                ,master_community_id NUMBER PATH '$.master_community_id'
                ,sub_community_id NUMBER PATH '$.sub_community_id'
                ,location_id NUMBER PATH '$.location_id'
                ,district_id NUMBER PATH '$.district_id'
                ,state_id NUMBER PATH '$.state_id'
                ,country_code VARCHAR2 PATH '$.country_code'
                ,sma_code VARCHAR2 PATH '$.sma_code'
                ,code VARCHAR2 PATH '$.code'
                ,old_id NUMBER PATH '$.old_id'
                ,bu_id NUMBER PATH '$.bu_id'
                ,created_by VARCHAR2 PATH '$.created_by'
                ,creation_date TIMESTAMP PATH '$.creation_date'
                ,last_updated_by VARCHAR2 PATH '$.last_updated_by'
                ,last_update_date TIMESTAMP PATH '$.last_update_date'
                ,last_update_login VARCHAR2 PATH '$.last_update_login'
                ));


   rec_data           cur_data%ROWTYPE;
   l_err_code         VARCHAR2 (1);
   l_err_msg          VARCHAR2 (2000);
   l_primarykey       NUMBER;
   l_attribute_json   ps_community_master_t.attribute_json%TYPE;


   PROCEDURE process_data (p_method       IN VARCHAR2
                          ,p_primarykey   IN NUMBER
                          ,p_data         IN BLOB)
   IS
   BEGIN
      IF p_method = 'POST' THEN
         post_data (p_primarykey
                   ,p_data);
      ELSIF p_method = 'PUT' THEN
         put_data (p_primarykey
                  ,p_data);
      ELSIF p_method = 'DELETE' THEN
         delete_data (p_primarykey
                     ,p_data);
      END IF;
   END process_data;

   PROCEDURE post_data (p_primarykey   IN NUMBER
                       ,p_data         IN BLOB)
   IS
      l_seq_id   NUMBER := ps_transaction_id_s.NEXTVAL;
   BEGIN
      OPEN cur_data (p_data);

      FETCH cur_data INTO rec_data;

      CLOSE cur_data;

      BEGIN
         SELECT json_query (p_data format json,'$.attribute_json[*]') clobdata
          INTO l_attribute_json
          FROM dual;
      END;

      INSERT INTO ps_community_master_t (community_id
                                        ,object_version_no
                                        ,community_code
                                        ,community_name
                                        ,community_name_ar
                                        ,master_developer_id
                                        ,master_developer
                                        ,master_developer_ar
                                        ,master_community_id
                                        ,sub_community_id
                                        ,location_id
                                        ,district_id
                                        ,state_id
                                        ,country_code
                                        ,sma_code
                                        ,code
                                        ,old_id
                                        ,attribute_json
                                        ,bu_id
                                        ,created_by
                                        ,creation_date
                                        ,last_updated_by
                                        ,last_update_date
                                        ,last_update_login)
           VALUES (l_seq_id
                  ,rec_data.object_version_no
                  ,rec_data.community_code
                  ,rec_data.community_name
                  ,rec_data.community_name_ar
                  ,rec_data.master_developer_id
                  ,rec_data.master_developer
                  ,rec_data.master_developer_ar
                  ,rec_data.master_community_id
                  ,rec_data.sub_community_id
                  ,rec_data.location_id
                  ,rec_data.district_id
                  ,rec_data.state_id
                  ,rec_data.country_code
                  ,rec_data.sma_code
                  ,rec_data.code
                  ,rec_data.old_id
                  ,l_attribute_json
                  ,rec_data.bu_id
                  ,rec_data.created_by
                  --,rec_data.creation_date
                  ,SYSDATE
                  ,rec_data.last_updated_by
                  --                  ,rec_data.last_update_date
                  ,SYSDATE
                  ,rec_data.last_update_login);

      l_primarykey   := l_seq_id;


      COMMIT;

      l_err_code     := 'S';
      l_err_msg      := 'Information Saved Successfully';
      apex_json.open_object;
      apex_json.write ('p_err_code'
                      ,l_err_code);
      apex_json.write ('p_err_msg'
                      ,l_err_msg);
      apex_json.write ('p_primarykey'
                      ,l_primarykey);
      apex_json.close_object;
   EXCEPTION
      WHEN OTHERS THEN
         l_err_code   := 'E';
         l_err_msg    := 'API Error - ' || SQLERRM;
         DBMS_OUTPUT.put_line ('Error > ' || SQLCODE || SQLERRM);
         apex_json.open_object;
         apex_json.write ('p_err_code'
                         ,l_err_code);
         apex_json.write ('p_err_msg'
                         ,l_err_msg);
         apex_json.write ('p_primarykey'
                         ,l_primarykey);
         apex_json.close_object;
   END post_data;

   PROCEDURE put_data (p_primarykey   IN NUMBER
                      ,p_data         IN BLOB)
   IS
   BEGIN
      OPEN cur_data (p_data);

      FETCH cur_data INTO rec_data;

      CLOSE cur_data;

      BEGIN
         SELECT json_query (p_data format json,'$.attribute_json[*]') clobdata
          INTO l_attribute_json
          FROM dual;
      END;

      UPDATE ps_community_master_t
         SET object_version_no     = rec_data.object_version_no
            ,community_code        = rec_data.community_code
            ,community_name        = rec_data.community_name
            ,community_name_ar     = rec_data.community_name_ar
            ,master_developer_id   = rec_data.master_developer_id
            ,master_developer      = rec_data.master_developer
            ,master_developer_ar   = rec_data.master_developer_ar
            ,master_community_id   = rec_data.master_community_id
            ,sub_community_id      = rec_data.sub_community_id
            ,location_id           = rec_data.location_id
            ,district_id           = rec_data.district_id
            ,state_id              = rec_data.state_id
            ,country_code          = rec_data.country_code
            ,sma_code              = rec_data.sma_code
            ,code                  = rec_data.code
            ,old_id                = rec_data.old_id
            ,attribute_json        = l_attribute_json
            ,bu_id                 = rec_data.bu_id
            ,created_by            = rec_data.created_by
            ,creation_date         = rec_data.creation_date
            ,last_updated_by       = rec_data.last_updated_by
            ,last_update_date      = rec_data.last_update_date
            ,last_update_login     = rec_data.last_update_login
       WHERE community_id = rec_data.community_id;


      COMMIT;

      l_primarykey   := rec_data.community_id;
      l_err_code     := 'S';
      l_err_msg      := 'Information Saved Successfully';
      apex_json.open_object;
      apex_json.write ('p_err_code'
                      ,l_err_code);
      apex_json.write ('p_err_msg'
                      ,l_err_msg);
      apex_json.write ('p_primarykey'
                      ,l_primarykey);
      apex_json.close_object;
   EXCEPTION
      WHEN OTHERS THEN
         l_err_code   := 'E';
         l_err_msg    := 'API Error - ' || SQLERRM;
         apex_json.open_object;
         apex_json.write ('p_err_code'
                         ,l_err_code);
         apex_json.write ('p_err_msg'
                         ,l_err_msg);
         apex_json.write ('p_primarykey'
                         ,l_primarykey);
         apex_json.close_object;
   END put_data;

   PROCEDURE delete_data (p_primarykey   IN NUMBER
                         ,p_data         IN BLOB)
   IS
   BEGIN
      OPEN cur_data (p_data);

      FETCH cur_data INTO rec_data;

      CLOSE cur_data;

      DELETE FROM ps_community_master_t
            WHERE community_id = p_primarykey;


      COMMIT;
      l_primarykey   := rec_data.community_id;
      l_err_code     := 'S';
      l_err_msg      := 'Information Saved Successfully';
      apex_json.open_object;
      apex_json.write ('p_err_code'
                      ,l_err_code);
      apex_json.write ('p_err_msg'
                      ,l_err_msg);
      apex_json.write ('p_primarykey'
                      ,l_primarykey);
      apex_json.close_object;
   EXCEPTION
      WHEN OTHERS THEN
         l_err_code   := 'E';
         l_err_msg    := 'API Error - ' || SQLERRM;
         apex_json.open_object;
         apex_json.write ('p_err_code'
                         ,l_err_code);
         apex_json.write ('p_err_msg'
                         ,l_err_msg);
         apex_json.write ('p_primarykey'
                         ,l_primarykey);
         apex_json.close_object;
   END delete_data;
END ps_community_master_pkg;
