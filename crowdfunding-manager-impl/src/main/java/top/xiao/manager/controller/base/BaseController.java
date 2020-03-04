package top.xiao.manager.controller.base;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.xiao.utils.common.ApiResult;
import top.xiao.utils.common.ApiResultCode;
import top.xiao.utils.common.ApiResultCodeEnum;

/**
 * @author 肖
 * @version 1.0
 * @Package mvc.controller.base
 * @data 2019/12/17 18:23
 */
public class BaseController {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 成功处理，返回java对象结果集
     * @param object
     * @return
     */
    protected <T> ApiResult<T> success(T object){
        ApiResult<T> result = new ApiResult<>(ApiResultCodeEnum.C0000);
        result.setResult(object);
        return result;
    }

    /**
     * 成功处理，返回java对象结果集
     *
     * @param message
     * @return
     */
    protected <T> ApiResult<T> success(String message){
        ApiResult<T> result = new ApiResult<>(ApiResultCodeEnum.C0000);
        result.setMessage(message);
        return result;
    }

    /**
     * 成功处理，返回java对象结果集
     * @param object
     * @return
     */
    protected <T> ApiResult<T> success(T object, String message){
        ApiResult<T> result = new ApiResult<>(ApiResultCodeEnum.C0000);
        result.setResult(object);
        result.setMessage(message);
        return result;
    }

    /**
     * 返回默认错误信息
     * @return
     */
    protected <T> ApiResult<T> fail(){
        ApiResult<T> result = new ApiResult<>(ApiResultCodeEnum.E0000);
        return result;
    }

    /**
     * 返回指定错误信息
     * @param message 错误信息
     * @return
     */
    protected <T> ApiResult<T> fail(String message){
        ApiResult<T> result = new ApiResult<>(ApiResultCodeEnum.E0000);
        if(StringUtils.isNotBlank(message)){
            result.setMessage(message);
        }

 return result;
}
    /**
     * 返回java对象结果集
     * @param object
     * @param resultCode
     * @param <T>
     * @return
     */
    protected <T> ApiResult<T> returnObjectResult(T object, ApiResultCode resultCode){
        ApiResult<T> result = new ApiResult<>(resultCode);
        result.setResult(object);
        return result;
    }
    /**
     * 返回java对象结果集,自定义msg
     * @param object
     * @param resultCode
     * @param <T>
     * @return
     */
    protected <T> ApiResult returnObjectResult(T object, ApiResultCode resultCode, String message){
        ApiResult result = new ApiResult(resultCode,message);
        result.setResult(object);
        return result;
    }

    /**
     * 根据错误状态直接返回错误
     * @param errorCode
     * @return
     */
    protected <T> ApiResult<T> returnWrong(ApiResultCode errorCode){
        ApiResult result = new ApiResult(errorCode);
        return result;
    }

    /**
     * 根据错误状态直接返回错误
     * @param errorCode
     * @return
     */
    protected <T> ApiResult<T> returnWrong(ApiResultCode errorCode, String message){
        ApiResult result = new ApiResult(errorCode);
        if(StringUtils.isNotBlank(message)){
            result.setMessage(message);
        }
        return result;
    }

    /**
     * 返回自定义错误信息
     * @param errorCode
     * @return
     */
    protected <T> ApiResult<T> returnWrongWithMessage(ApiResultCode errorCode, String message){
        ApiResult result = new ApiResult(errorCode);
        if(StringUtils.isNotBlank(message)){
            result.setMessage(message);
        }
        return result;
    }
}
