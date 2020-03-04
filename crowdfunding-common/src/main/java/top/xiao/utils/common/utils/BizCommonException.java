package top.xiao.utils.common.utils;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.utils.common.utils
 * @data 2020/2/25 16:19
 */
public class BizCommonException extends RuntimeException {
    private int code;
    private String message;

    public BizCommonException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizCommonException(BizCommonExceptionEnum bizCommonExceptionEnum) {
        this.code = bizCommonExceptionEnum.getCode();
        this.message = bizCommonExceptionEnum.getMessage();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
