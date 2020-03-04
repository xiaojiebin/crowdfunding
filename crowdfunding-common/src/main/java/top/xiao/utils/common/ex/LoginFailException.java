package top.xiao.utils.common.ex;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.utils.common.ex
 * @data 2020/2/20 13:57
 */
public class LoginFailException extends RuntimeException {
    public LoginFailException(String message) {
        super(message);
    }
}
