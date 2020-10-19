package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vip.epss.domain.User;
import vip.epss.service.UserService;
import vip.epss.utils.MD5Util;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/19 0019
 * @描述
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public String toLogin(){
        System.out.println(MD5Util.getMD5("123456"));
        return "login";
    }

    @RequestMapping(value = "/loginCheck",method = {RequestMethod.POST})
    public String loginCheck(User user){
        //对密码加密
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        System.out.println(user.getPassword());
        return "admin";
    }
}
