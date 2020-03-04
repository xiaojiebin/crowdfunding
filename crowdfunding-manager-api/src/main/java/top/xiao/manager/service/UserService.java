package top.xiao.manager.service;

import top.xiao.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.manager.service
 * @data 2020/1/7 17:20
 */

public interface UserService {
    void insert(User user);

    List<User> getAllUser();

    User queryUser(User user);

    void regUser(User user);
}
