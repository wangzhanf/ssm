package vip.epss.service.impl;

import org.springframework.stereotype.Service;
import vip.epss.domain.User;
import vip.epss.service.UserService;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/19 0019
 * @描述
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Override
    public User selectOne(Integer uid) {
        return null;
    }
}
