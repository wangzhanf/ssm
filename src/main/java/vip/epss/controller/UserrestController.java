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

    @RequestMapping(value = "/index")
    public String index() {
//        return "forward:/WEB-INF/user.jsp";
        return "user";
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public MessageAndData list(
            UserCondition condition,/*检索条件*/
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) throws ParseException {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        String userName = "";
        if (condition.getUsername() != null && !condition.getUsername().equals("")) {
            userName = "%" + condition.getUsername() + "%";
            criteria.andUsernameLike(userName);
        }

        Integer uidC = condition.getUidCondition();
        if (uidC != null && uidC != -1 && condition.getUid() != null) {//不限定条件
            if (uidC == 0) {
                criteria.andUidGreaterThan(condition.getUid());
            }
            if (uidC == 1) {
                criteria.andUidEqualTo(condition.getUid());
            }
            if (uidC == 2) {
                criteria.andUidLessThan(condition.getUid());
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate1 = dateFormat.parse("1970-01-01");
        Date endDate1 = dateFormat.parse("2999-12-31");

        Date startDate = condition.getStartDate() == null ? startDate1 : condition.getStartDate();
        Date endDate = condition.getEndDate() == null ? endDate1 : condition.getEndDate();
        if (startDate.after(endDate)) {
            Date tempDate = startDate;
            startDate = endDate;
            endDate = tempDate;
        }

        criteria.andAddTimeBetween(startDate, endDate);


        //初始化,约束
        PageHelper.startPage(pageNum, pageSize);
        List<User> lists = userService.selectByExample(example);
        //使用pageHelper的方式封装数据,默认的导航列表长度为8
        PageInfo pageInfo = new PageInfo(lists, 8);
        return MessageAndData.success("").add("pageInfo", pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/opt/{id}", method = RequestMethod.GET)
    public MessageAndData optSelectPrimaryKey(@PathVariable("id") Integer id) {
        User obj = userService.selectByPrimaryKey(id);
        return MessageAndData.success("查询成功").add("obj", obj);
    }


    @ResponseBody
    @RequestMapping(value = "/opt", method = RequestMethod.POST)
    public MessageAndData optInsert(User obj) {
        Integer i = userService.insertSelective(obj);
        if (i > 0) {
            return MessageAndData.success("成功添加" + i + "条记录");
        } else {
            return MessageAndData.error("添加失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/opt/{ids}", method = RequestMethod.DELETE)
    public MessageAndData deletes(@PathVariable("ids") String ids) {
        //获取传递过来的uid列表,分解为一个集合对象
        List<Integer> iIds = new ArrayList<Integer>();
        String splitSymbol = "\\D";
        String[] sIds = ids.split(splitSymbol);
        Integer i = null;
        for (String sId : sIds) {
            iIds.add(Integer.parseInt(sId));
        }
        if (iIds.size() > 1) {//删除多条记录
            UserExample example = new UserExample();
            example.createCriteria().andUidIn(iIds);
            i = userService.deleteByExample(example);
        } else {//删除一条记录
            i = userService.deleteByPrimaryKey(iIds.get(0));
        }
        return MessageAndData.success("删除成功" + i + "条记录").add("num", i);
    }


    //    如果使用put方法,记得要在web.xml中添加相应过滤器,对象不能封装
    @ResponseBody
    @RequestMapping(value = "/opt", method = RequestMethod.PUT)
    public MessageAndData optUpdate(User obj) {
        int i = userService.updateByPrimaryKeySelective(obj);
        if (i > 0) {
            return MessageAndData.success("成功修改" + i + "条记录");
        } else {
            return MessageAndData.error("修改失败");
        }
    }


}
