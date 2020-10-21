package vip.epss.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.User;
import vip.epss.domain.UserExample;
import vip.epss.service.UserService;
import vip.epss.utils.MessageAndData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/19 0019
 * @描述
 */
@Controller
@RequestMapping("/userrest")
public class UserrestController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.GET})
    public MessageAndData list(
            @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize

    ){
        //初始化,约束
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.selectByExample(null);
        //使用pageHelper的方式封装数据,默认的导航列表长度为8
        PageInfo pageInfo = new PageInfo(users, 8);
        return MessageAndData.success("").add("pageInfo",pageInfo);
    }


    @ResponseBody
    @RequestMapping(value = "/opt",method = RequestMethod.POST)
    public MessageAndData optInsert(User user){
        Integer i = userService.insertSelective(user);
        if(i>0){
            return MessageAndData.success("成功添加"+i+"条记录");
        }else{
            return MessageAndData.error("添加失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/opt/{uids}",method = RequestMethod.DELETE)
    public MessageAndData deletes(@PathVariable("uids")String uids){
        //获取传递过来的uid列表,分解为一个集合对象
        List<Integer> iUids = new ArrayList<Integer>();
        String[] sUids = uids.split("-");
        Integer i = null;
        for (String sUid : sUids) {
            iUids.add(Integer.parseInt(sUid));
        }
        if(iUids.size() > 1) {//删除多条记录
            //创建一个UserExample对象
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUidIn(iUids);
            //执行批量删除
            i = userService.deleteByExample(userExample);
        }else{//删除一条记录
            i = userService.deleteByPrimaryKey(iUids.get(0));
        }
        return MessageAndData.success("删除成功").add("num", i);
    }


    //    如果使用put方法,记得要在web.xml中添加相应过滤器,对象不能封装
    @ResponseBody
    @RequestMapping(value = "/opt",method = RequestMethod.PUT)
    public MessageAndData optUpdate(User user){
        System.out.println(user);
        int i = userService.updateByPrimaryKey(user);
        if(i>0){
            return MessageAndData.success("成功修改"+i+"条记录");
        }else{
            return MessageAndData.error("修改失败");
        }
    }



}
