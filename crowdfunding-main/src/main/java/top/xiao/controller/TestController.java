package top.xiao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xiao.manager.service.TestService;
import top.xiao.pojo.User;

import java.util.List;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.controller
 * @data 2019/9/29 10:48
 */
@Controller
@RequestMapping("/user")
@Api(value = "/user", tags = "User接口")
public class TestController {

    @Autowired
    private TestService service;

    @ResponseBody
    @RequestMapping("/test.htm")
    @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息", httpMethod = "GET", response = User.class)
    public String test() {
        System.out.println("执行了controller");
        service.insert();
        return "测试";
    }

    @RequestMapping("/getAllUser.do")
    @ResponseBody
    @ApiOperation(value = "/getAllUser.do", notes = "获取全部用户", httpMethod = "GET")
    public void getAll() {
        List<User> allUser = service.getAllUser();
        for (User user : allUser
        ) {
            System.out.println(user);
        }
    }


    @RequestMapping("/getUser")
    @ResponseBody
    @ApiOperation(value = "获取用户", notes = "获取到用户数据", httpMethod = "POST")
    public void getUser() {
        System.out.println("请求访问到了.");
    }
}
