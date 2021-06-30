package com.spring.contractvb.Utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;


public class DBAUtils {
    

/**
     * This method is used to get instance of simplejdbccall by passing below parameters
     * @param procedure
     * @param jdbcTemplate
     * @return
     */
    public static SimpleJdbcCall callStoredProcedure(String procedure, JdbcTemplate jdbcTemplate){
        SimpleJdbcCall  executor = new SimpleJdbcCall(jdbcTemplate)
            .withProcedureName(procedure);
        return executor;
    }

//  pavke
//  funcation 

}
