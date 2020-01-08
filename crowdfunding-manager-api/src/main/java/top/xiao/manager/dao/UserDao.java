package top.xiao.manager.dao;

import top.xiao.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.manager.dao
 * @data 2020/1/7 14:46
 */
public interface UserDao {
    void insert(User user);

    List<User> getAllUser();
}
