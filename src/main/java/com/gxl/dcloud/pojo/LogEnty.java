package com.gxl.dcloud.pojo;

import java.io.Serializable;

public class LogEnty implements Serializable{
    private Integer id;

    private Integer userId;

    private String module;

    private String method;

    private Long responseData;

    private String ip;

    private Long data;

    private String commite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Long getResponseData() {
        return responseData;
    }

    public void setResponseData(Long responseData) {
        this.responseData = responseData;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public String getCommite() {
        return commite;
    }

    public void setCommite(String commite) {
        this.commite = commite == null ? null : commite.trim();
    }

    @Override
    public String toString() {
        return "LogEnty{" +
                "id=" + id +
                ", userId=" + userId +
                ", module='" + module + '\'' +
                ", method='" + method + '\'' +
                ", responseData=" + responseData +
                ", ip='" + ip + '\'' +
                ", data=" + data +
                ", commite='" + commite + '\'' +
                '}';
    }
}