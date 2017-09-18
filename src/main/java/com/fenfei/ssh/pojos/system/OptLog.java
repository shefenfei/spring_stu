package com.fenfei.ssh.pojos.system;

import java.io.Serializable;

/**
 * Created by shefenfei on 2017/8/29.
 * 系统日志操作表
 */
public class OptLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private String logId;           //日志主键
    private String type;            //日志类型
    private String title;           //日志标题
    private String remoteAddr;          //请求地址
    private String requestUri;          //URI
    private String method;          //请求方式
    private String params;          //提交参数
    private String exception;           //异常
    private String operateDate;           //开始时间
    private String timeout;         //结束时间
    private String userId;          //用户ID

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "OptLog{" +
                "logId='" + logId + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", remoteAddr='" + remoteAddr + '\'' +
                ", requestUri='" + requestUri + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", exception='" + exception + '\'' +
                ", operateDate=" + operateDate +
                ", timeout='" + timeout + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
