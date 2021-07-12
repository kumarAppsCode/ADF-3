package com.sample.contract.Utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class DBAUtils {

    /**
     * This method is used to get instance of simplejdbccall by passing below parameters
     * @param schema
     * @param pkge
     * @param procedure
     * @param jdbcTemplate
     * @return
     */
    // public static SimpleJdbcCall callStoredPackage(String schema, String pkge, String procedure, JdbcTemplate jdbcTemplate){
    //     SimpleJdbcCall  executor = new SimpleJdbcCall(jdbcTemplate)
    //         .withSchemaName(schema)
    //         .withCatalogName(pkge)
    //         .withProcedureName(procedure)
    //         .withoutProcedureColumnMetaDataAccess();
    //     return executor;
    // }

     /**
     * This method is used to get instance of simplejdbccall by passing below parameters
     * @param schema
     * @param pkge
     * @param procedure
     * @param jdbcTemplate
     * @return
     */
    public static SimpleJdbcCall callStoredPackage(String pkge, String procedure, JdbcTemplate jdbcTemplate){
        SimpleJdbcCall  executor = new SimpleJdbcCall(jdbcTemplate)
            .withCatalogName(pkge)
            .withProcedureName(procedure);
        return executor;
    }


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


    /**
     * This method is used to get instance of simplejdbccall by passing below parameters
     * @param procedure
     * @param jdbcTemplate
     * @return
     */
    public static SimpleJdbcCall callFunction(String functionName, JdbcTemplate jdbcTemplate){
        SimpleJdbcCall  executor = new SimpleJdbcCall(jdbcTemplate)
            .withFunctionName(functionName);
        return executor;
    }


}
