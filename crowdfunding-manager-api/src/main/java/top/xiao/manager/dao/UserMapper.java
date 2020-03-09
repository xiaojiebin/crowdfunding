package top.xiao.manager.dao;

import org.apache.ibatis.annotations.Param;
import top.xiao.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User queryUserlogin(User user);


    int regUser(User user);

    List<User> pageUser(@Param("start") int start, @Param("count") int count);

    int countPage();

    int findUserCount(User user);

    List<User> findUser(@Param("user") User user, @Param("start") int start, @Param("count") int count);

    int deleteUserByIds(String[] ids);
}