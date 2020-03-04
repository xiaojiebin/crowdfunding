package top.xiao.utils.common;

public interface ApiResultCode {
    /**
     * 返回状态码
     *
     * @return
     */
    public String getCode();

    /**
     * 返回错误信息
     *
     * @return
     */
    public String getMessage();
}
