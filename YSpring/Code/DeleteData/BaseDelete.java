**********************************************************************************************************************
        // delete by id
    @RequestMapping(value = "/function1/{id}", method = RequestMethod.DELETE)
    public String deleteByFunctionId1(@PathVariable("id") Integer func_id) {

        if (func_id > 0) {
            if (function_SO.deleteFunctionById1(func_id)) {
                return "Record Deleted Successfully";
            } else {
                return "Function Cannot delete";
            }
        } else {
            return func_id + "can't be negative";
        }
    }
=============================================
    // delete
    public Boolean deleteFunctionById1(Integer id) {
        try {
            function_RO.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
**********************************************************************************************************************
      @RequestMapping(value = "function/delete/", method = RequestMethod.POST)
    public String deleteMultipleFunction(@RequestBody List<Function_EO> fund_id) {

        if (function_SO.deleteMultipleFunctionId(fund_id)) {
            return "Record Deleted Successfully";
        } else {
            return "No Data Found";
        }
    }
=============================================
    public Boolean deleteMultipleFunctionId(List<Function_EO> ids) {
        try {
            function_RO.deleteAll(ids);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
**********************************************************************************************************************





