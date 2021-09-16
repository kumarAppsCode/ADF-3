    @RequestMapping(value = "/posarea/{area_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update_PosArea(
                        @RequestBody PosAreaAllEO contentBody,
                        @PathVariable(name = "area_id") BigDecimal area_id
                        ){
        return posAreaAllso.update_PosArea(contentBody, area_id);
    }
*********************************************************************************************************    

public ResponseEntity<Object> update_PosArea(PosAreaAllEO contentBody, BigDecimal area_id) {
      Optional<PosAreaAllEO> isVal = posAreaAllro.findById(area_id);
      PosAreaAllEO isls=isVal.get();
      // System.out.println("DB Object Version==>"+isls.getObject_version_number());
      // System.out.println("Json"+ contentBody.getObject_version_number());
      String dbObjVer=isls.getObject_version_number()==null?"-1":isls.getObject_version_number().toString();
      String JsonObjVer=contentBody.getObject_version_number()==null?"0":contentBody.getObject_version_number().toString();
      
      // System.out.println("DB Object Version==>"+dbObjVer);
      // System.out.println("Json==>"+ JsonObjVer);
            if(isVal.isPresent()){
                  if(dbObjVer.equals(JsonObjVer)){
                    PosAreaAllEO ls=posAreaAllro.save(contentBody);
                    return ResponseEntity.ok(ls);
                  }else{
                    return ResponseEntity.ok("Error: Object Version Number Mismatch");
                  }  
             }else{
                return ResponseEntity.ok("No Data Found");
            }
    }
