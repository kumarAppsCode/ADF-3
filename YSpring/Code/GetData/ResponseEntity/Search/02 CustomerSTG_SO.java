package com.contract.module.contractmodule.Services;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;


@Service
public class CustomerSTG_SO extends NamedParameterJdbcDaoSupport{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(JdbcTemplate jdbcTemplate) {
        super.setDataSource(jdbcTemplate.getDataSource());
    }

// ************************************************************
    public List<Map<String, Object>> getall_customer() {
        List<Map<String, Object>> items = null;
        Map<String, Object> params = new HashMap();
        
        String customerSQL=
        "SELECT CUST_ID, CUSTOMER_NUMBER, CUSTOMER_NAME, CUSTOMER_NAME_TL," 
        +"SALES_PERSON_ID, LEAD_ID, ORIG_SYSTEM_REF, ACTIVE_YN, "
        +"CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE," 
        +"LAST_UPDATE_LOGIN, TITLE, SUR_NAME, "
        +"MIDDLE_NAME, FIRST_NAME, PASSPORT_NO "
        +"FROM xxstg_customer";

        try {
            // params.put("p_pro_id", p_propertyid);
            items = getNamedParameterJdbcTemplate().queryForList(customerSQL, params);
        } catch (Exception exp) {
            // LOGGER.error(exp.getMessage(), exp);
        }
        return items;
    }
// ************************************************************
    public List<Map<String, Object>> getall_customerSite(BigDecimal p_cust_id, BigDecimal p_org_id) {
        List<Map<String, Object>> items = null;
        Map<String, Object> params = new HashMap();
        
        String customerSiteSQL=
        "SELECT ORG_ID, CUST_SITE_ID, CUST_ID, SITE_NUMBER,"
        +"SITE_NAME, ADDRESS1, ADDRESS2, ADDRESS3, ADDRESS4,"
        +"CITY, POSTAL_CODE, STATE, PROVINCE, COUNTY, COUNTRY,"
        +"ORIG_SYSTEM_REF, PRIMARY_YN, ACTIVE_YN, CREATED_BY, CREATION_DATE,"
        +"LAST_UPDATED_BY, LAST_UPDATE_DATE, LAST_UPDATE_LOGIN " 
        +" FROM xxstg_cust_sites where CUST_ID=:p_customer_id and ORG_ID=:p_organization_id";
        System.out.println("customerSiteSQL=>"+customerSiteSQL);    
        try {
            params.put("p_customer_id", p_cust_id);
            params.put("p_organization_id", p_org_id);
            System.out.println("==>"+customerSiteSQL);
            items = getNamedParameterJdbcTemplate().queryForList(customerSiteSQL, params);
        } catch (Exception exp) {
            System.out.println(exp.toString());            
        }
        return items;
    } 
// ************************************************************

    public List<Map<String, Object>> getall_customerContact(BigDecimal p_cust_id, BigDecimal p_cust_site_id) {
        List<Map<String, Object>> items = null;
        Map<String, Object> params = new HashMap();
        
        String customerContactSQL=
        "SELECT CUST_CONTACT_ID, CUST_ID, CUST_SITE_ID," 
        +"CONTACT_NAME, CONTACT_NAME_TL, DESIGNATION," 
        +"MOBILE_NUMBER, PHONE_NUMBER, FAX_NUMBER, EMAIL_ID," 
        +"PASSPORT_NUMBER, PASSPORT_EXP_DATE, NATIONAL_ID_NUMBER," 
        +"NATIONAL_ID_EXP_DATE, ORIG_SYSTEM_REF, ACTIVE_YN, "
        +"PRIMARY_YN, CREATED_BY, CREATION_DATE, LAST_UPDATED_BY," 
        +"LAST_UPDATE_DATE, LAST_UPDATE_LOGIN "
        +" FROM xxstg_cust_contacts"
        +" where CUST_ID=:p_cust and CUST_SITE_ID =:p_cust_site";

        // System.out.println("customerSiteSQL=>"+customerContactSQL);    
        try {
            params.put("p_cust", p_cust_id);
            params.put("p_cust_site", p_cust_site_id);
            // System.out.println("==>"+customerContactSQL);
            items = getNamedParameterJdbcTemplate().queryForList(customerContactSQL, params);
        } catch (Exception exp) {
            System.out.println(exp.toString());            
        }
        return items;
    }






    

}
