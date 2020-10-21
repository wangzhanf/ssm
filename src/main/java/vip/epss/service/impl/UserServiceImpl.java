package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;
import vip.epss.domain.UserExample;
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
    public long countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserExample example) {
        return userMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int insert(User record) {
        //对传递过来的明文密码加密为密文然后比对
        record.setPassword(MD5Util.getMD5(record.getPassword()));
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        //对传递过来的明文密码加密为密文然后比对
        record.setPassword(MD5Util.getMD5(record.getPassword()));
        return userMapper.insertSelective(record);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public User selectByPrimaryKey(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int updateByExampleSelective(User record, UserExample example) {
        //对传递过来的明文密码加密为密文然后比对
        record.setPassword(MD5Util.getMD5(record.getPassword()));
        return userMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(User record, UserExample example) {
        //对传递过来的明文密码加密为密文然后比对
        record.setPassword(MD5Util.getMD5(record.getPassword()));
        return userMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        //对传递过来的明文密码加密为密文然后比对
        record.setPassword(MD5Util.getMD5(record.getPassword()));
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        //对传递过来的明文密码加密为密文然后比对
        record.setPassword(MD5Util.getMD5(record.getPassword()));
        return userMapper.updateByPrimaryKey(record);
    }

}
