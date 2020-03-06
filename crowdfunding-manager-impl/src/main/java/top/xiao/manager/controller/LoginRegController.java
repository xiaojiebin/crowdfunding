package top.xiao.manager.controller;

import com.google.gson.Gson;
import com.sun.deploy.net.HttpResponse;
import com.sun.istack.internal.logging.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xiao.manager.controller.base.BaseController;
import top.xiao.manager.service.UserService;
import top.xiao.pojo.User;
import top.xiao.utils.common.ApiResult;
import top.xiao.utils.common.utils.AjaxCommonObject;
import top.xiao.utils.common.utils.BizCommonException;
import top.xiao.utils.common.utils.Const;
import top.xiao.utils.common.utils.GetExceptionMessage;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.manager.controller
 * @data 2020/1/7 17:02
 */
@Controller
public class LoginRegController extends BaseController {

    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserService service;


    /**
     * 注册
     *
     * @param user    封装前端数据
     * @param session 创建成功后用于存储信息
     * @return
     */
    @RequestMapping("/doReg.do")
    @ResponseBody
    public ApiResult<String> doReg(User user, HttpSession session) {
        try {
            service.regUser(user);
            user.setUserpswd(null);
            session.setAttribute(Const.LOGIN_USER, user);
            return success("用户注册成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return fail(e.getMessage());
        }
    }

    /**
     * 登陆
     *
     * @param user    前端信息
     * @param session session域
     * @return
     */
    @ResponseBody
    @RequestMapping("/loginAjax.do")
    public ApiResult<Object> login(User user, HttpSession session) {
        try {
            service.queryUser(user);
            session.setAttribute(Const.LOGIN_USER, user);
            return success("登陆成功!");
        } catch (BizCommonException e) {
            return fail();
        }
    }

    @ResponseBody
    @RequestMapping("/logout.do")
    public ApiResult<String> logout(HttpSession session) {
        Object attribute = session.getAttribute(Const.LOGIN_USER);
        if (attribute != null) {
            session.removeAttribute(Const.LOGIN_USER);
            return success("注销成功");
        }
        return fail("此用户已经退出系统");

    }

}
