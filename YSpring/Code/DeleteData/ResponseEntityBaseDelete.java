********Single Delete*****************************************************************************************************
  @DeleteMapping(value = "/lookupvalue/{id}")
    public ResponseEntity<Object> deletelookupValueid(@PathVariable("id") Integer id){
        
        return lookupValueServices.deleteLookupValueId(id);

    }       
*************************************************************************************************************************
	public ResponseEntity<Object> deleteLookupValueId(Integer id) {
   
      if(lookupValue_ro.findById(id).isPresent()){
        lookupValue_ro.deleteById(id);
        if(lookupValue_ro.findById(id).isPresent()){
            return ResponseEntity.unprocessableEntity().body("Failed to deleted the record");
        }else{
            return ResponseEntity.ok().body("Record Deleted Successfully");
        }
      }else{
        return  ResponseEntity.unprocessableEntity().body("No Record Found");
      }
*************************************************************************************************************************
