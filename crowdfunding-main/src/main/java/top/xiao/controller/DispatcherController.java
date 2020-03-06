package top.xiao.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.xiao.manager.controller.base.BaseController;
import top.xiao.manager.service.UserService;
import top.xiao.pojo.User;
import top.xiao.utils.common.ApiResult;
import top.xiao.utils.common.utils.AjaxResult;
import top.xiao.utils.common.utils.Const;
import top.xiao.utils.common.utils.MD5Util;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.controller
 * @data 2020/2/6 16:12
 */
@Controller
public class DispatcherController extends BaseController {

    Logger logger = Logger.getLogger(DispatcherController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/index.htm")
    public String index() {
        return "index";
    }

    @RequestMapping("/doReg.htm")
    public String reg() {
        return "reg";
    }

    @RequestMapping("/login.htm")
    public String login() {

        return "login";
    }

    @RequestMapping("error.htm")
    public String eror() {
        return "error/error";
    }

    @RequestMapping("/freemarker")
    public ModelAndView freemarker() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "hello world");
        modelAndView.setViewName("home");
        return modelAndView;

    }

    @RequestMapping("/main.htm")
    public String main() {
        return "main";
    }


    @RequestMapping("/user.htm")
    public String user() {
        return "user";
    }

    @RequestMapping("/top.htm")
    public String top() {
        return "common/top";
    }
}
