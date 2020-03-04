package top.xiao.pojo.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础分页条件查询对象
 * @author liuhui
 *
 */
@Data
public class BasePageQuery {

	@ApiModelProperty(value = "当前页数", required = false)
	private int pageNum = 1;
	@ApiModelProperty(value = "每页条数", required = false)
	private int pageSize = 10;
	@ApiModelProperty(value = "自定义排序字段", required = false)
	private String sortName;
	@ApiModelProperty(value = "升序或降序字段", required = false)
	private String order;
	@ApiModelProperty(value = "分页字段外的其他动态参数封装成一个Map对象,提交参数的格式为:params['英文属性名']", required = false)
	private Map<String, Object> params = new HashMap<String, Object>();
	
	/**
	 * 根据key获取参数
	 * @param key
	 * @return
	 */
	public Object getParamsField(String key){
        return this.params.get(key);
    }
	/**
	 * 设置参数
	 * @param key
	 * @param value
	 */
    public void addParamsField(String key, Object value) {

        this.params.put(key, value);
    }
}
