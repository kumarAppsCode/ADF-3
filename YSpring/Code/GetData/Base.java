

***************************************************************************************************************************
   @RequestMapping("getall")
     public List<Function_EO> getFunctionByIdandName(
                                          @RequestParam(value = "id", required = false) Set<Integer> funId,
                                          @RequestParam(value = "fname", required = false) String fname
                                                       ){
         return functionservices.getFunctionByIdListandName(funId, fname);
     }
===============================================
    public List<Function_EO> getFunctionByIdListandName(Set<Integer> funId, String fname) {
        if(funId==null && fname==null){
             List<Function_EO> al= new ArrayList<>();
             functionrepo.findAll().forEach(al::add);
             return al;
        }else{
            return functionrepo.findByFuncidInOrFuncnameContaining(funId, fname);
        }
	}
***************************************************************************************************************************
   // Get All Record
    @RequestMapping("/function")
    public List<Function_EO> getFunction() {
        return (List<Function_EO>) function_SO.getAllFunction();
    }
===========================================================
        public List<Function_EO> getAllFunction() {
        List<Function_EO> getAllfunls = new ArrayList<>();
        function_RO.findAll().forEach(getAllfunls::add);
        return getAllfunls;
    }
***************************************************************************************************************************
    //Path Variable to find 1 records--Default
    @RequestMapping(value = "/function/{fun_id}")
    public Optional<Function_EO> getFunctionById(@PathVariable("fun_id") Integer function_id) {
        return function_SO.findFunctionById(function_id);
    }
===========================================================
    // find by Id
    public Optional<Function_EO> findFunctionById(Integer function_id) {
        return function_RO.findById(function_id);
    }
***************************************************************************************************************************    
    // Get All - Request param
    @RequestMapping("/functionName")
    public List<Function_EO> getFunction(@RequestParam(value = "fun_name", required = false) String funName) {
        return (List<Function_EO>) function_SO.getAllFunctionName(funName);
    }
===========================================================    
    public List<Function_EO> getAllFunctionName(String funName) {
        if (funName == null) {
            List<Function_EO> getAllfunls = new ArrayList<>();
            function_RO.findAll().forEach(getAllfunls::add);
            return getAllfunls;
        } else {
            return function_RO.findAllByfuncnameContains(funName);
            // return function_jpa_rO.findAllByfunc_name(funName);
        }
    }
    List<Function_EO> findAllByfuncnameContains(String funname); --- in Repo
***************************************************************************************************************************    








