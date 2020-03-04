package top.xiao.utils.common.utils;

public enum BizCommonExceptionEnum {
    SERVER_ERROR(500, "服务器异常,请联系系统运维人员"),
    NO_THIS_USER(400, "没有此用户");


    private int code;
    private String message;

    private BizCommonExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

