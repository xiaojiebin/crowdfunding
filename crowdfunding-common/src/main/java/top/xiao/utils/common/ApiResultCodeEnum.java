package top.xiao.utils.common;

/**
 * @program: API接口返回状态码
 * @author: hgc
 * @create: 2018-07-07 13:06
 **/
public enum ApiResultCodeEnum implements ApiResultCode {
    /**
     * 所有请求成功都返回该状态
     */
    C0000("处理成功"),
    /**
     * 所有后台处理的未知异常都返回该状态
     */
    E0000("服务器正忙，请稍后"),
    /**
     * 参数校验异常返回状态
     */
    E0002("参数不全或无效"),

    /**
     * 用户未登录
     */
    E0003("用户未登录"),

    /**
     * 记录重复
     */
    E0004("记录已存在"),

    /**
     * 资源权限校验失败
     */
    E0005("权限不足,请联系管理员");


    private String message;
    private ApiResultCodeEnum(String message){
        this.message = message;
    }
    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
