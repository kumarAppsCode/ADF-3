extends NamedParameterJdbcDaoSupport
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
======================================================================

@RequestMapping(value = "allPro")
    public List<Map<String, Object>> getProLs(
        @RequestParam (value = "p_propertyid", required = false) String p_propertyid){ 
            List<Map<String, Object>> result=
            propertyMater_so.getSalesInvoiceBrowserMoveOrderItems(p_propertyid);
    return result;
    }
*****************
public List<Map<String, Object>> getSalesInvoiceBrowserMoveOrderItems(String p_propertyid){
    List<Map<String, Object>> items = null;
    Map<String, Object> params = new HashMap();
    String sql="SELECT "+ 
    "PROPERTY_ID, PROPERTY_NAME,  PROPERTY_NUMBER "+
    "FROM xxpm_property_master where PROPERTY_ID=:p_pro_id";
    System.out.println("Step 1==>"+p_propertyid);

    try {
        params.put("p_pro_id", p_propertyid);
        items = getNamedParameterJdbcTemplate().queryForList(sql, params);
    } catch (Exception exp) {
        LOGGER.error(exp.getMessage(), exp);
    }
    return items;
}

****************************
