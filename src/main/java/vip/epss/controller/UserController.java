package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vip.epss.domain.User;
import vip.epss.service.UserService;
import vip.epss.utils.MD5Util;
import vip.epss.utils.MessageAndData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        return "login";
    }

    @RequestMapping(value = "/loginCheck")
    public String loginCheck(User user, HttpServletRequest request){
        User byUser = userService.selectByUser(user);
        if(byUser!=null){
//            将用户基本信息记录在session中
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(3600);//会话时间3600秒
            session.setAttribute("USER_SESSION",byUser.getUsername());
            return "admin";
        }else{
            return "login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
//            将用户基本信息从session中清除
            HttpSession session = request.getSession();
            session.setAttribute("USER_SESSION",null);
            session.invalidate();//使所有的session失效
            return "login";
    }
}
