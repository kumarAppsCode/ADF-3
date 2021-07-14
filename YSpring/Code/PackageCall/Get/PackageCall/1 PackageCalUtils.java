package com.services.mail.PackageCalling;

import java.sql.Types;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component
public class PackageCalUtils {
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PackageCalUtils(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Map<String, Object> submitPackage(
            String P_FUNC_ID, String P_REF_ID,
            String P_LEVEL_NO, String P_TABLE_NAME,
            String P_STATUS_COLUMN, String P_PK_COLUMN,
            String P_AMOUNT,String P_ATTRIBUTE1,
            String P_ATTRIBUTE2,String P_ATTRIBUTE3,
            String P_ATTRIBUTE4, String P_ATTRIBUTE5
    ){

        SimpleJdbcCall simpleJdbcCall;
        // Map<String, Object> inParamMap = null;        
        simpleJdbcCall=new SimpleJdbcCall(this.jdbcTemplate)
                        .withCatalogName("XXFND_UTIL_PKG")
                        .withProcedureName("SUBMIT_FOR_APPROVAL");
        simpleJdbcCall.declareParameters(
            new SqlParameter("P_FUNC_ID",      Types.VARCHAR),
            new SqlParameter("P_REF_ID",       Types.VARCHAR),
            new SqlParameter("P_LEVEL_NO",     Types.VARCHAR),
            new SqlParameter("P_TABLE_NAME",   Types.VARCHAR),
            new SqlParameter("P_STATUS_COLUMN",Types.VARCHAR),
            new SqlParameter("P_PK_COLUMN",    Types.VARCHAR),
            new SqlParameter("P_AMOUNT",       Types.VARCHAR),
            new SqlParameter("P_ATTRIBUTE1",   Types.VARCHAR),
            new SqlParameter("P_ATTRIBUTE2",   Types.VARCHAR),
            new SqlParameter("P_ATTRIBUTE3",   Types.VARCHAR),
            new SqlParameter("P_ATTRIBUTE4",   Types.VARCHAR),
            new SqlParameter("P_ATTRIBUTE5",   Types.VARCHAR),
            // out param 
            new SqlOutParameter("P_FLOW_STATUS",    Types.VARCHAR),
            new SqlOutParameter("P_FLOW_WITH",      Types.VARCHAR),
            new SqlOutParameter("P_APPROVER_NAME",  Types.VARCHAR),
            new SqlOutParameter("P_APPROVER_EMAIL", Types.VARCHAR),
            new SqlOutParameter("P_USER_GRP_ID",    Types.VARCHAR),
            new SqlOutParameter("P_ERR_CODE",       Types.VARCHAR),
            new SqlOutParameter("P_ERR_MSG",        Types.VARCHAR)
           ).compile();
           


        SqlParameterSource param=new MapSqlParameterSource()
           .addValue("P_FUNC_ID",      P_FUNC_ID)
           .addValue("P_REF_ID",       P_REF_ID)
           .addValue("P_LEVEL_NO",     P_LEVEL_NO)
           .addValue("P_TABLE_NAME",   P_TABLE_NAME)
           .addValue("P_STATUS_COLUMN",P_STATUS_COLUMN)
           .addValue("P_PK_COLUMN",    P_PK_COLUMN)
           .addValue("P_AMOUNT",       P_AMOUNT)
           .addValue("P_ATTRIBUTE1",   P_ATTRIBUTE1)
           .addValue("P_ATTRIBUTE2",   P_ATTRIBUTE2)
           .addValue("P_ATTRIBUTE3",   P_ATTRIBUTE3)
           .addValue("P_ATTRIBUTE4",   P_ATTRIBUTE4)
           .addValue("P_ATTRIBUTE5",   P_ATTRIBUTE5);
           Map<String, Object> simpleJdbcCallResult =  simpleJdbcCall.execute(param);
           return simpleJdbcCallResult;
       }






}
