package vip.epss.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vip.epss.domain.Types;
import vip.epss.domain.TypesCondition;
import vip.epss.domain.TypesExample;
import vip.epss.service.TypesService;
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
@RequestMapping(value = "/typesrest")
public class TypesrestController {
    @Autowired
    private TypesService typesService;

    //当需要展示所有类别列表时
    @ResponseBody
    @RequestMapping(value = "/listJSON")
    public MessageAndData listJSON() {
        List<Types> lists = typesService.selectByExample(null);
        return MessageAndData.success("").add("lists", lists);
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "forward:/WEB-INF/types.jsp";
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public MessageAndData list(
            TypesCondition condition,/*检索条件*/
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize

    ) throws ParseException {

        TypesExample example = new TypesExample();
        TypesExample.Criteria criteria = example.createCriteria();

        String name = "";
        if (condition.getTname() != null && !condition.getTname().equals("")) {
            name = "%" + condition.getTname() + "%";
            criteria.andTnameLike(name);
        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse("1970-01-01");
        Date endDate = dateFormat.parse("2999-12-31");

        startDate = condition.getStartDate() == null ? startDate : condition.getStartDate();
        endDate = condition.getEndDate() == null ? endDate : condition.getEndDate();
        if (startDate.after(endDate)) {
            Date tempDate = startDate;
            startDate = endDate;
            endDate = tempDate;
        }

        criteria.andAddTimeBetween(startDate, endDate);

        //初始化,约束
        PageHelper.startPage(pageNum, pageSize);
        List<Types> lists = typesService.selectByExample(example);
        //使用pageHelper的方式封装数据,默认的导航列表长度为8
        PageInfo pageInfo = new PageInfo(lists, 8);
        return MessageAndData.success("").add("pageInfo", pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/opt/{id}", method = RequestMethod.GET)
    public MessageAndData optSelectPrimaryKey(@PathVariable("id") Integer id) {
        Types obj = typesService.selectByPrimaryKey(id);
        return MessageAndData.success("查询成功").add("obj", obj);
    }


    @ResponseBody
    @RequestMapping(value = "/opt", method = RequestMethod.POST)
    public MessageAndData optInsert(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Types obj) throws IOException {
        //如果没有新的上传文件则不触发上传操作和改名操作
        if (!file.isEmpty()) {
            String up = FileUploadUtil.up(file);
            obj.setTavatar(up);
        }

        Integer i = typesService.insertSelective(obj);
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
            TypesExample example = new TypesExample();
            example.createCriteria().andTidIn(iIds);
            i = typesService.deleteByExample(example);
        } else {//删除一条记录
            i = typesService.deleteByPrimaryKey(iIds.get(0));
        }
        return MessageAndData.success("删除成功" + i + "条记录").add("num", i);
    }


    @ResponseBody
    @RequestMapping(value = "/opt", method = RequestMethod.PUT, headers = "content-type=multipart/form-data")
    public MessageAndData optUpdateRest(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Types obj) throws IOException {
        //如果没有新的上传文件则不触发上传操作和改名操作
        if (!file.isEmpty()) {
            String up = FileUploadUtil.up(file);
            obj.setTavatar(up);
        }

        int i = typesService.updateByPrimaryKeySelective(obj);
        if (i > 0) {
            return MessageAndData.success("成功修改" + i + "条记录");
        } else {
            return MessageAndData.error("修改失败");
        }
    }
}
