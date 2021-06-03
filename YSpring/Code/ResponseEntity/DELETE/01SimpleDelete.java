    @RequestMapping(value = "/contract/{contract_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete_Contract(
                        @PathVariable(name = "contract_id") BigDecimal contract_id
                        ){
        return contract_so.delete_Contract(contract_id);
    }
------------------------------------------------------------------------------------------------------------
        public ResponseEntity<Object> delete_Contract(BigDecimal contract_id) {
        
        Optional<Contract_EO> isVal = contract_rp.findById(contract_id);
          if(isVal.isPresent()){
            contract_rp.deleteById(contract_id);
            return ResponseEntity.ok("Record deleted Successfully");
          }else{
            return ResponseEntity.ok("No Data found");
          }
    }
------------------------------------------------------------------------------------------------------------
