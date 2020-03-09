package top.xiao.utils.common.ex;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.utils.common.ex
 * @data 2020/3/7 15:50
 */
public class NotExistException extends RuntimeException {
    public NotExistException(String message) {
        super(message);
    }
}
