package top.xiao.manager.controller;

import com.sun.istack.internal.logging.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xiao.manager.controller.base.BaseController;
import top.xiao.manager.service.UserService;
import top.xiao.pojo.User;
import top.xiao.utils.common.ApiResult;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.manager.controller
 * @data 2020/1/7 17:02
 */
@Controller
@Api(tags = "用户管理")
@ResponseBody
public class UserController extends BaseController {

    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserService service;

    @ApiOperation("用户添加")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ApiResult<String> addUser(@RequestBody User user) {
        service.insert(user);
        return success("测试成功");
    }
}
