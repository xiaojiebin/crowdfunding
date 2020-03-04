package top.xiao.utils.common.utils;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.utils.common.utils
 * @data 2020/2/25 16:25
 */
public class AjaxCommonObject {
    private int code;
    private String message;
    private Object data;

    public AjaxCommonObject() {
        this.code = 0;
        this.message = "ajax业务请求正确响应";
    }

    public AjaxCommonObject(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public AjaxCommonObject(BizCommonException bizCommonException) {
        this.code = bizCommonException.getCode();
        this.message = bizCommonException.getMessage();
    }

    public AjaxCommonObject(BizCommonExceptionEnum bizCommonExceptionEnum) {
        this.code = bizCommonExceptionEnum.getCode();
        this.message = bizCommonExceptionEnum.getMessage();
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

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}