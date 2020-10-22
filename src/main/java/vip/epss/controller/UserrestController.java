package vip.epss.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.epss.domain.User;
import vip.epss.domain.UserCondition;
import vip.epss.domain.UserExample;
import vip.epss.service.UserService;
import vip.epss.utils.MessageAndData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            UserCondition userCondition,/*检索条件*/
            @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize

    ) throws ParseException {
        System.out.println(userCondition);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        String userName="";
        if(userCondition.getUsername()!=null && !userCondition.getUsername().equals("")){
            userName = "%"+userCondition.getUsername()+"%";
            criteria.andUsernameLike(userName);
        }

        Integer uidC = userCondition.getUidCondition();
        if(uidC!=null && uidC!=-1 && userCondition.getUid()!=null){//不限定条件
            if(uidC == 0){
                criteria.andUidGreaterThan(userCondition.getUid());
            }
            if(uidC == 1){
                criteria.andUidEqualTo(userCondition.getUid());
            }
            if(uidC == 2){
                criteria.andUidLessThan(userCondition.getUid());
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate1 = dateFormat.parse("1970-01-01");
        Date endDate1 = dateFormat.parse("2999-12-31");

        Date startDate = userCondition.getStartDate()==null?startDate1:userCondition.getStartDate();
        Date endDate = userCondition.getEndDate()==null?endDate1:userCondition.getEndDate();
        if(startDate.after(endDate)){
            Date tempDate = startDate;
            startDate = endDate;
            endDate = tempDate;
        }

        criteria.andAddTimeBetween(startDate,endDate);




        //初始化,约束
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.selectByExample(userExample);
        //使用pageHelper的方式封装数据,默认的导航列表长度为8
        PageInfo pageInfo = new PageInfo(users, 8);
        return MessageAndData.success("").add("pageInfo",pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/opt/{uid}",method = RequestMethod.GET)
    public MessageAndData optSelectPrimaryKey(@PathVariable("uid")Integer uid){
        User user = userService.selectByPrimaryKey(uid);
        return MessageAndData.success("查询成功").add("user",user);
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
        return MessageAndData.success("删除成功"+i+"条记录").add("num", i);
    }


    //    如果使用put方法,记得要在web.xml中添加相应过滤器,对象不能封装
    @ResponseBody
    @RequestMapping(value = "/opt",method = RequestMethod.PUT)
    public MessageAndData optUpdate(User user){
        System.out.println(user);
        int i = userService.updateByPrimaryKeySelective(user);
        if(i>0){
            return MessageAndData.success("成功修改"+i+"条记录");
        }else{
            return MessageAndData.error("修改失败");
        }
    }



}
