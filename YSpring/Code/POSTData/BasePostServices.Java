
*******************************************************************************************************************
    // Save
    @RequestMapping(value = "/function", method = RequestMethod.POST)
    public Function_EO createFunction(@RequestBody Function_EO function) {

        return function_SO.createFunction(function);
    }
===========================================================================
        // save
    public Function_EO createFunction(Function_EO function) {

        return function_RO.save(function);
    }
*********************************************************************************************************************
    // Save Bulk Data
    @RequestMapping(value = "/functions", method = RequestMethod.POST)
    public List<Function_EO> createFunctions(@RequestBody List<Function_EO> fun) {

        return function_SO.createFunctions(fun);
    }
===========================================================================    
    // Save All
    public List<Function_EO> createFunctions(List<Function_EO> fun) {
        return (List<Function_EO>) function_RO.saveAll(fun);
    }
*********************************************************************************************************************
