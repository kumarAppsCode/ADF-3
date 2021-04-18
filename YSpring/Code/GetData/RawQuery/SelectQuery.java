    @RequestMapping(value = "selectPro")
    public List<Property_EO> getSelectProperty(
        @RequestParam (value = "p_propertyid", required = false) String p_propertyid){ 
            
            List<Property_EO> result=propertyMater_so.getSelectAllProperty(p_propertyid);

    return result;
    }
================================================================   
public List<Property_EO> getSelectAllProperty(String p_propertyid) {
        Map<String, Object> params = new HashMap();
        List<Property_EO> property = null;
        String sql="SELECT "+ 
        "PROPERTY_ID, PROPERTY_NAME,  PROPERTY_NUMBER "+
        "FROM xxpm_property_master where PROPERTY_ID=:p_pro_id";
        System.out.println("Step 1==>"+p_propertyid);
        try{
            params.put("p_pro_id", p_propertyid);

            property= getNamedParameterJdbcTemplate().query(sql, params, 
                new RowMapper(){
                    @Override
                    public Property_EO mapRow(ResultSet rs, int rowNum) throws SQLException{
                        Property_EO pro=new Property_EO();
                        System.out.println("==>"+rs.getBigDecimal("PROPERTY_ID"));
                        pro.setPropertyId(rs.getBigDecimal("PROPERTY_ID"));
                        pro.setPropertyName(rs.getString("PROPERTY_NAME"));
                        pro.setPropertyNumber(rs.getString("PROPERTY_NUMBER"));
                        return pro;
                    }
            });
        }catch(Exception e){
            System.out.println("Error==>"+e.toString());
        }
        return property;
    }
    *******************************************************************************************
  public BigDecimal propertyId;
  public String propertyName;
  public String propertyNumber;
