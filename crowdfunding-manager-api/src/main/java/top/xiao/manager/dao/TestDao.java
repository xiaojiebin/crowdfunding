package top.xiao.manager.dao;

import top.xiao.pojo.User;

import java.util.List;
import java.util.Map;


public interface TestDao {

    public void insert(Map map);

    List<User> getAllUser();
}
