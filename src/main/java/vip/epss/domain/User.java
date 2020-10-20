package vip.epss.domain;

import lombok.Data;

import java.util.Date;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/19 0019
 * @描述
 */
@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private Date addTime;
}
