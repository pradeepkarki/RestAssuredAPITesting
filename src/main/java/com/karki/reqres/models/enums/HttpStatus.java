package com.karki.reqres.models.enums;

public enum HttpStatus {

    OK(200, "OK"),
    CREATED(201, "Created");

    private final int code;
    private final String desc;

    HttpStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
