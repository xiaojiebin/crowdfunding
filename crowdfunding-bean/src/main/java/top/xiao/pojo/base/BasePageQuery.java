package top.xiao.pojo.base;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础分页条件查询对象
 *
 * @author xiao
 */
@Data
public class BasePageQuery {


    private int pageNum = 1;

    private int pageSize = 10;

    private int totalPage = 1;

    private String sortName;

    private String order;

    private Map<String, Object> params = new HashMap<String, Object>();

    /**
     * 根据key获取参数
     *
     * @param key
     * @return
     */
    public Object getParamsField(String key) {
        return this.params.get(key);
    }

    /**
     * 设置参数
     *
     * @param key
     * @param value
     */
    public void addParamsField(String key, Object value) {

        this.params.put(key, value);
    }
}
