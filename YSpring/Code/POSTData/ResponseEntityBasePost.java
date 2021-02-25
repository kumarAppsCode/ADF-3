    @RequestMapping(value = "/lookuptypes", method = RequestMethod.POST)
    public ResponseEntity<Object> createLookupTypes(@RequestBody LookupType_EO lkentity){

        return lookupType_so.saveLookupType(lkentity);    

    }
=========================================================================
  	public ResponseEntity<Object> saveLookupType(LookupType_EO lkentity) {
		
                LookupType_EO save_lk=lookupType_ro.save(lkentity);
                if(lookupType_ro.findById(save_lk.getLookupTypeId()).isPresent()){
                        return ResponseEntity.accepted().body("Record Saved Successfully");                               
                }else{
                        return ResponseEntity.unprocessableEntity().body("Failed to create record");
                }
	}
************************************************************************************************************************
