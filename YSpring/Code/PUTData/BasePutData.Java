
    @RequestMapping(value = "/function", method = RequestMethod.PUT)
    public Function_EO updateFunction(@RequestBody Function_EO incomingFunction) {

        return function_SO.updateFunction(incomingFunction);
    }
===================================================
    // update
    public Function_EO updateFunction(Function_EO fun_data) {
        return function_RO.save(fun_data);
    }
***************************************************************************************************
