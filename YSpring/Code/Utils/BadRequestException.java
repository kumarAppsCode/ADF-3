package com.module.admin_module.Utils;

import java.util.List;

public class BadRequestException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<ErrorHandle> error;

    public BadRequestException(String message, List<ErrorHandle> error) {
        super(message);
        this.error = error;
    }

    public List<ErrorHandle> getError() {
        return error;
    }

    public void setError(List<ErrorHandle> error) {
        this.error = error;
    }

 




}
