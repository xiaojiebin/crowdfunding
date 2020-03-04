package top.xiao.utils.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 肖
 * @version 1.0
 * @Package mvc.utils
 * @data 2019/12/17 18:06
 */
@Data
public class ApiResult<T> implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final long serialVersionUID = 1L;

    /**
     * 集返回状态码
     */
    @ApiModelProperty("状态码，C0000:成功，其他异常")
    private String code;
    /**
     * 返回提示信息
     */
    @ApiModelProperty("提示信息")
    private String message;
    /**
     * 结果集
     */
    @ApiModelProperty("结果集")
    private T result;

    public ApiResult() {
    }

    /**
     * 根据状态枚举设置返回结果状态信息
     * @param apiResultCode
     */
    public ApiResult(ApiResultCode apiResultCode){
        this.code = apiResultCode.getCode();
        this.message = apiResultCode.getMessage();
    }

    /**
     * 自定义message
     * @param apiResultCode
     * @param message
     */
    public ApiResult(ApiResultCode apiResultCode,String message){
        this.code = apiResultCode.getCode();
        this.message = message;
    }
}
