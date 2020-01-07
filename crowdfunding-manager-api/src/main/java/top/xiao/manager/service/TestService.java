package top.xiao.manager.service;

import top.xiao.pojo.User;

import java.util.List;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.manager.service
 * @data 2019/9/29 9:34
 */
public interface TestService {

    public void insert();

    List<User> getAllUser();
}
