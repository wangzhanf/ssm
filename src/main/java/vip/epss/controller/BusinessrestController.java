package vip.epss.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vip.epss.domain.*;
import vip.epss.service.ActivityService;
import vip.epss.service.BusinessService;
import vip.epss.utils.FileUploadUtil;
import vip.epss.utils.MessageAndData;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/26 0026
 * @描述
 */
@Controller
@RequestMapping(value = "/businessrest")
public class BusinessrestController {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private ActivityService activityService;

    @ResponseBody
    @RequestMapping(value = "/listJSON")
    public MessageAndData listJSON() {
        List<Business> lists = businessService.selectByExample(null);
        return MessageAndData.success("").add("lists", lists);
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "forward:/WEB-INF/business.jsp";
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public MessageAndData list(
            BusinessCondition condition,/*检索条件*/
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) throws ParseException {

        BusinessExample example = new BusinessExample();
        BusinessExample.Criteria criteria = example.createCriteria();

        String name = "";
        if (condition.getBname() != null && !condition.getBname().equals("")) {
            name = "%" + condition.getBname() + "%";
            criteria.andBnameLike(name);
        }

        example.setOrderByClause("bid");


//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = dateFormat.parse("1970-01-01");
//        Date endDate = dateFormat.parse("2999-12-31");
//
//        startDate = condition.getStartDate() == null ? startDate : condition.getStartDate();
//        endDate = condition.getEndDate() == null ? endDate : condition.getEndDate();
//        if (startDate.after(endDate)) {
//            Date tempDate = startDate;
//            startDate = endDate;
//            endDate = tempDate;
//        }
//
//        criteria.andAddTimeBetween(startDate, endDate);

        //获取所有的活动列表

        List<Activity> activities = activityService.selectByExample(null);

        //初始化,约束
        PageHelper.startPage(pageNum, pageSize);

        List<Business> lists = businessService.selectByExampleWithObject(example);
        //使用pageHelper的方式封装数据,默认的导航列表长度为8
        PageInfo pageInfo = new PageInfo(lists, 8);
        return MessageAndData.success("").add("pageInfo", pageInfo).add("activities",activities);
    }

    @ResponseBody
    @RequestMapping(value = "/opt/{id}", method = RequestMethod.GET)
    public MessageAndData optSelectPrimaryKey(@PathVariable("id") Integer id) {
        Business obj = businessService.selectByPrimaryKey(id);
        return MessageAndData.success("查询成功").add("obj", obj);
    }

    @ResponseBody
    @RequestMapping(value = "/opt/{bid}/{aid}/{status}", method = RequestMethod.GET)
    public MessageAndData optSelectPrimaryKey(@PathVariable("bid") Integer bid,@PathVariable("aid") Integer aid,@PathVariable("status") Boolean status) {
        int i = businessService.updateStatus(bid,aid,status);
        return MessageAndData.success("处理成功").add("num", i);
    }


    @ResponseBody
    @RequestMapping(value = "/opt", method = RequestMethod.POST)
    public MessageAndData optInsert(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Business obj) throws IOException {
        //如果没有新的上传文件则不触发上传操作和改名操作
        if (!file.isEmpty()) {
            String up = FileUploadUtil.up(file);
            obj.setBavatar(up);
        }

        Integer i = businessService.insertSelective(obj);
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
        /*
        if (iIds.size() > 1) {//删除多条记录
            BusinessExample example = new BusinessExample();
            example.createCriteria().andBidIn(iIds);
            i = businessService.deleteByExample(example);
        } else {//删除一条记录
            i = businessService.deleteByPrimaryKey(iIds.get(0));
        }
        */
        for (Integer iId : iIds) {
            i += businessService.deleteByPrimaryKey(iIds.get(iId));
        }
        return MessageAndData.success("删除成功" + i + "条记录").add("num", i);
    }

    @ResponseBody
    @RequestMapping(value = "/opt", method = RequestMethod.PUT, headers = "content-type=multipart/form-data")
    public MessageAndData optUpdateRest(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Business obj) throws IOException {
        //如果没有新的上传文件则不触发上传操作和改名操作
        if (!file.isEmpty()) {
            String up = FileUploadUtil.up(file);
            obj.setBavatar(up);
        }
        //如果涉及到复选框的操作,特别是前台如果通过复选框设置单一字段的状态,需要处理,否则出现能设置上不能取消
        //原因是使用了框架的自动封装功能,如果没有选中则封装为null,example判断如果为null则不会添加到更新字段中
        if (obj.getBstatus() == null) {
            obj.setBstatus(false);
        }

        int i = businessService.updateByPrimaryKeySelective(obj);
        if (i > 0) {
            return MessageAndData.success("成功修改" + i + "条记录");
        } else {
            return MessageAndData.error("修改失败");
        }
    }
}
