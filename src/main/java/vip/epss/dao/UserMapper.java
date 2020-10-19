package vip.epss.dao;

import vip.epss.domain.User;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/19 0019
 * @描述
 */
public interface UserMapper {
    public abstract User selectOne(Integer uid);
}
