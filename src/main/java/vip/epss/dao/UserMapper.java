package vip.epss.dao;

import vip.epss.domain.User;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/19 0019
 * @描述
 */
public interface UserMapper {
    public abstract User selectByPrimaryKey(Integer key);
    public abstract List<User> select();
    public abstract Integer insert(User record);
    public abstract Integer delete(Integer key);
    public abstract Integer update(User record);
    //特定应用
    public abstract User selectByUser(User record);//用于登录
    public abstract List<User> selectByUsername(String str);//用于查重
}
