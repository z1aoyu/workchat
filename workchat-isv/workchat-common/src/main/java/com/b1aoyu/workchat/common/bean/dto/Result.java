package com.b1aoyu.workchat.common.bean.dto;

/**
 * @author：z1aoyu 2022-01-28
 * @description:
 */
public class Result {

    private static final long serialVersionUID = -3826891916021780628L;

    private String code;

    private String messages;

    public static Result buildResult(ResponseCode code) {
        return new Result(code.getCode(), code.getTitle());
    }

    public static Result buildResult(ResponseCode code, String messages) {
        return new Result(code.getCode(), messages);
    }

    public static Result buildResult(String code, String messages) {
        return new Result(code, messages);
    }

    public static Result buildResult(ResponseCode code, ResponseCode messages) {
        return new Result(code.getCode(), messages.getTitle());
    }

    public static Result buildSuccessResult() {
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getTitle());
    }

    public static Result buildErrorResult() {
        return new Result(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getTitle());
    }

    public static Result buildErrorResult(String messages) {
        return new Result(ResponseCode.ERROR.getCode(), messages);
    }

    public Result(String code, String messages) {
        this.code = code;
        this.messages = messages;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getmessages() {
        return messages;
    }

    public void setmessages(String messages) {
        this.messages = messages;
    }

}
