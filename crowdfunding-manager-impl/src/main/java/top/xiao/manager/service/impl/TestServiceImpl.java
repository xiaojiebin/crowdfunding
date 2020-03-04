package top.xiao.manager.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xiao.manager.dao.TestDao;
import top.xiao.manager.service.TestService;
import top.xiao.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.manager.impl
 * @data 2019/9/29 9:35
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {

    Logger logger = Logger.getLogger(TestServiceImpl.class);

    @Autowired
    private TestDao dao;

    @Override
    public void insert() {
        Map map = new HashMap();
        map.put("username", "zhangsan");
        map.put("password", "1234");

        Map map1 = new HashMap<>();
        map1.put("username", "xiaoxiao");
        map1.put("password", "123");
        dao.insert(map);
        logger.info("测试事物是否回滚 >>>>>>>>>>>>>>>>>>>>>> 第一个用户添加完毕");
        dao.insert(map1);
        //        执行时出现异常

    }

    @Override
    public List<User> getAllUser() {

        return null;
    //    return dao.getAllUser();
    }


}
