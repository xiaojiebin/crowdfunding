package top.xiao.manager.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xiao.manager.dao.UserDao;
import top.xiao.manager.dao.UserMapper;
import top.xiao.manager.service.UserService;
import top.xiao.pojo.User;
import top.xiao.utils.common.ex.ExistedException;
import top.xiao.utils.common.ex.LoginFailException;
import top.xiao.utils.common.ex.NotExistException;
import top.xiao.utils.common.utils.Const;
import top.xiao.utils.common.utils.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.manager.service.impl
 * @data 2020/1/7 17:21
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper dao;

    @Override
    public void insert(User user) {
        dao.insert(user);
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User queryUser(User user) {
        User Ruser = dao.queryUserlogin(user);
        String md5 = MD5Util.getMD5(Const.MD5_UTIL, user.getUserpswd(), Ruser.getSalt());
        if (md5.equals(Ruser.getUserpswd())) {
            logger.info("您本次登陆的账号为 --> " + user.getLoginacct() + "密码匹配为 ——> "
                    + md5.equals(Ruser.getUserpswd()) + "登陆成功！");
            return user;
        } else {
            throw new LoginFailException("您输入的账号或密码错误!");
        }
    }

    @Override
    public void regUser(User user) {
        //校验账号是否已经存在
        User existedSign = dao.queryUserlogin(user);
        if (existedSign != null) {
            throw new ExistedException("您输入的账号已经存在,请重新输入！");
        }
        //密码加密
        String[] md5 = MD5Util.getMD5(Const.MD5_UTIL, user.getUserpswd(), 12);
        user.setSalt(md5[1]);
        user.setUserpswd(md5[0]);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreatetime(sdf.format(d));
        int i = dao.insert(user);
    }


    /**
     * 分页展示用户信息
     *
     * @param user
     * @return
     */
    @Override
    public List<User> pageUser(User user) {
        int pageNum = user.getPageNum();
        int start = (pageNum - 1) * user.getPageSize();
        //获取总页数
        //总条数
        int totalNumber = dao.countPage();
        int pageSize = user.getPageSize();
        int pages = totalNumber / pageSize;
        if (totalNumber % pageSize != 0) {
            pages++;
        }
        int count = user.getPageSize();
        List<User> users = dao.pageUser(start, count);
        users.get(0).setTotalPage(pages);
        users.get(0).setPageNum(user.getPageNum());
        return users;
    }

    /**
     * 查询+分页
     *
     * @param user
     * @return
     */
    @Override
    public List<User> findUser(User user) {
        int pageNum = user.getPageNum();
        int start = (pageNum - 1) * user.getPageSize();
        int totalNumber = dao.findUserCount(user);
        int pageSize = user.getPageSize();
        int pages = totalNumber / pageSize;
        if (totalNumber % pageSize != 0) {
            pages++;
        }
        int count = user.getPageSize();
        List<User> users = dao.findUser(user, start, count);
        users.get(0).setTotalPage(pages);
        users.get(0).setPageNum(user.getPageNum());
        return users;
    }

    @Override
    public void deleteUser(int id){
        int i = dao.deleteByPrimaryKey(id);
        if (i==0){
            throw  new NotExistException("此用户已删除");
        }

    }

    @Override
    public String deleteUserByIds(String[] ids) {

        int i=dao.deleteUserByIds(ids);
        if (i<=0){
            return "删除失败！";
        }
        return "删除成功!";
    }
}
