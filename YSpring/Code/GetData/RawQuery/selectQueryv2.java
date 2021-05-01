import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sample.contract.Entity.Property_EO;
import com.sample.contract.Utils.DBAUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;


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
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(JdbcTemplate jdbcTemplate) {
        super.setDataSource(jdbcTemplate.getDataSource());
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
