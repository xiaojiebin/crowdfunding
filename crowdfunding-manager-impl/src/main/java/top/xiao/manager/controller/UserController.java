package top.xiao.manager.controller;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.xiao.manager.controller.base.BaseController;
import top.xiao.manager.service.UserService;
import top.xiao.pojo.User;
import top.xiao.pojo.base.BasePageQuery;
import top.xiao.utils.common.ApiResult;

import java.util.List;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.manager.controller
 * @data 2020/3/4 19:26
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService service;

    @RequestMapping("/user.htm")
    public String userHtm() {

        return "user";
    }

    @RequestMapping("/user.do")
    @ResponseBody
    public ApiResult<List<User>> user(User user) {
        List<User> users = service.pageUser(user);
        return success(users);
    }
}
