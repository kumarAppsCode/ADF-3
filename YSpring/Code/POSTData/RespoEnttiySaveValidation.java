long totProcEndTime = System.currentTimeMillis();
System.out.println("total time taken for proc execution for all item :: " + (totProcEndTime - totProcStartTime) + " ms");
long totProcStartTime = System.currentTimeMillis();
******************
@RequestMapping(value = "/lookuptypesval", method = RequestMethod.POST)
    public ResponseEntity<Object> createLookupTypeswithVal(@RequestBody LookupType_EO lkentity){
        return lookupType_so.savewithValidation(lkentity);
    }
============
  	public ResponseEntity<Object> savewithValidation(LookupType_EO lkentity) {
                List<ErrorHandle>  error= lookuptyeValidate.validateSave(lkentity);      
                if(error.size()>0){
                        // System.out.println("===****Error****===");
                        // api.setErrorMessage(error);
                        // api.setStatusCode(HttpStatus.BAD_REQUEST.value());
                        // return ResponseEntity.unprocessableEntity().body(api);
                        throw new BadRequestException("bad Request", error);
                }else{
                        LookupType_EO save_lk=lookupType_ro.save(lkentity);
                        if(lookupType_ro.findById(save_lk.getLookupTypeId()).isPresent()){
                                api.setData("Record Saved Successfully");
                                api.setStatusCode(HttpStatus.OK.value());
                                return ResponseEntity.accepted().body(api);                               
                        }else{
                                api.setErrorMessage("Failed to create record");
                                api.setStatusCode(HttpStatus.OK.value());
                                return ResponseEntity.unprocessableEntity().body(api);
                       }
                }
	}
******************************************************************************************************************
