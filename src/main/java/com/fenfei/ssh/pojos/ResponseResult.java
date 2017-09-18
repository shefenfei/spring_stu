package com.fenfei.ssh.pojos;

import java.io.Serializable;

/**
 * Created by shefenfei on 2017/8/30.
 */
public class ResponseResult implements Serializable {

    private int status;
    private String message;
    private Object object;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
