package org.bob.learn.server.web.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private Object value;

    public static Result failure(String code, String msg){
        return result(code,msg,null);
    }

    public static Result success(String code, Object value){
        return result(code,null,value);
    }

    public static Result result(String code,String msg, Object value){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setValue(value);
        return result;
    }

}
