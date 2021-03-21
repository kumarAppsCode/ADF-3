 @RequestMapping(value = "contract", method = RequestMethod.GET)
    public ResponseEntity<Object> searchContract(
        @RequestParam(name = "contractName", required = false)String contractName,
        @RequestParam(name = "contractNumber", required = false)String contractNumber,
        // @RequestParam(name = "contractDate", required = false) String contractDate,
        @RequestParam(name = "bu", required = false) String bu,
        @RequestParam(name = "customerName", required = false)String customerName,
        @RequestParam(name = "siteNumber", required = false)String siteNumber
        ){
        
        // return searchContractRO_so.searchContract(contractName,contractNumber,contractDate,bu,customerName,siteNumber);
        return searchContractRO_so.searchContract(contractName,contractNumber,bu,customerName,siteNumber);

    }
*************************************************************************************************************************
public ResponseEntity<Object> searchContract(
        String contractName, String contractNumber,
        String bu, String customerName, 
        String siteNumber) {
         APIResponse api=new APIResponse();    
       if(contractName==null&&
          contractNumber==null&&
          bu==null&&customerName==null&&siteNumber==null){
            List<SearchContractRO_EO> ls = searchContractRO_rp.findAll();
             if(ls.isEmpty()){
                 api.setErrorMessage("No Data found");
                 api.setStatusCode(HttpStatus.NOT_FOUND);
                 return ResponseEntity.unprocessableEntity().body(api);
             }else{
                api.setData(ls);
                api.setStatusCode(HttpStatus.ACCEPTED);
                return ResponseEntity.ok().body(api);
             }
       }else{

         List<SearchContractRO_EO> ls = 
         searchContractRO_rp.
         customeContractSearch(contractName, contractNumber, bu, customerName, siteNumber);
         if(ls.isEmpty()){
            api.setErrorMessage("No Data found");
            api.setStatusCode(HttpStatus.NOT_FOUND);
            return ResponseEntity.unprocessableEntity().body(api);
         }else{
            api.setData(ls);
            api.setStatusCode(HttpStatus.ACCEPTED);
            return ResponseEntity.ok().body(api);
         }
}     
}
********************************************************************************************************


    String rawQueryM2="select " 
    +"CONTRACT_ID, CONTRACT_NUMBER, CONTRACT_NAME, CONTRACT_DATE, CONTRACT_START_DATE, CONTRACT_END_DATE, CONTRACT_AMOUNT, ORG_ID, CUST_ID, CUST_SITE_ID, CUST_CONTACT_ID, DESCRIPTION, ACTIVE_YN, CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, LAST_UPDATE_LOGIN, ORG_NAME, CUSTOMER_NUMBER, CUSTOMER_NAME, SITE_NUMBER, ADDRESS1, ADDRESS2, ADDRESS3, ADDRESS4, CITY, CONTACT_NAME, MOBILE_NUMBER, PHONE_NUMBER, EMAIL_ID "
                        +"from XXSM_CONTRACT_HEADER_V "
                        +"where " 
                        +"NVL(CONTRACT_NAME, 'XXX') IN NVL(:contractName, CONTRACT_NAME)"
                        +"and NVL(CONTRACT_NUMBER, 'XXX') IN NVL(:contractNumber, CONTRACT_NUMBER)"
                        // +"and to_date(contract_date, 'DD-MM-YYYY') = NVL(:contractDate, to_date(contract_date, 'DD-MM-YYYY'))"
                        +"and NVL(ORG_NAME, 'XXX') IN NVL(:bu, ORG_NAME)"
                        +"and NVL(CUSTOMER_NAME, 'XXX') IN NVL(:customerName, CUSTOMER_NAME)"
                        +"and NVL(SITE_NUMBER, 'XXX') IN NVL(:siteNumber, SITE_NUMBER)"
                        ;



        @Query(nativeQuery = true, value = rawQueryM2)
        List<SearchContractRO_EO> customeContractSearch(
        @Param("contractName") String contractName,
        @Param("contractNumber") String contractNumber,
        // @Param("contractDate") String contractDate,
        @Param("bu") String bu,
        @Param("customerName") String customerName,
        @Param("siteNumber") String siteNumber
        );   
