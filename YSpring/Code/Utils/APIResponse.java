    private String  sysdate;
    private Object StatusCode;
    private Object Data;
    private Object ErrorMessage;

    public APIResponse() {
        this.sysdate = GenericUtil.getCurrentdate();
        StatusCode = getStatusCode();
        Data = getData();
        ErrorMessage = getErrorMessage();
    }


// getter 
// setter
