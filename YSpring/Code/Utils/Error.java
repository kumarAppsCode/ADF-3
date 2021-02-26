package com.module.admin_module.Utils;

public class ErrorHandle {
    
    private String target;
    private String message;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorHandle(String target, String message) {
        this.target = target;
        this.message = message;
    }
    

}
