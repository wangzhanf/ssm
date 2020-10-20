package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;
import vip.epss.service.UserService;
import vip.epss.utils.MD5Util;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/19 0019
 * @描述
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer key) {
        System.out.println("service的方法被调用了");
        return userMapper.selectByPrimaryKey(key);
    }

    @Override
    public List<User> select() {
        return userMapper.select();
    }

    @Override
    public Integer insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public Integer delete(Integer key) {
        return userMapper.delete(key);
    }

    @Override
    public Integer update(User record) {
        return userMapper.update(record);
    }

    @Override
    public User selectByUser(User record) {
        //对传递过来的明文密码加密为密文然后比对
        record.setPassword(MD5Util.getMD5(record.getPassword()));
        return userMapper.selectByUser(record);
    }

    @Override
    public List<User> selectByUsername(String str) {
        return userMapper.selectByUsername(str);
    }
}
