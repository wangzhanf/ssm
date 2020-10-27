package vip.epss.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vip.epss.domain.Goods;
import vip.epss.domain.GoodsCondition;
import vip.epss.domain.GoodsExample;
import vip.epss.service.GoodsService;
import vip.epss.utils.MessageAndData;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/19 0019
 * @描述
 */
@Controller
@RequestMapping("/goodsrest")
public class GoodsrestController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/index")
    public String index(){
        return "forward:/WEB-INF/goods.jsp";
    }

    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.GET})
    public MessageAndData list(
            GoodsCondition condition,/*检索条件*/
            @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize

    ) throws ParseException {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        if(condition.getGid()!=null){
            criteria.andGidEqualTo(condition.getGid());
        }

        String name="";
        if(condition.getGname()!=null && !condition.getGname().equals("")){
            name = "%"+condition.getGname()+"%";
            criteria.andGnameLike(name);
        }

        Double minPrice = 0.0;
        Double maxPrice = 9.9E+5;
        minPrice = condition.getMinPrice()==null?minPrice:condition.getMinPrice();
        maxPrice = condition.getMaxPrice()==null?maxPrice:condition.getMaxPrice();
        if(minPrice>maxPrice){
            Double temp = minPrice;
            minPrice = maxPrice;
            maxPrice = temp;
        }
        criteria.andGpriceBetween(minPrice,maxPrice);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse("1970-01-01");
        Date endDate = dateFormat.parse("2999-12-31");

        startDate = condition.getStartDate()==null?startDate:condition.getStartDate();
        endDate = condition.getEndDate()==null?endDate:condition.getEndDate();
        if(startDate.after(endDate)){
            Date tempDate = startDate;
            startDate = endDate;
            endDate = tempDate;
        }

        criteria.andAddTimeBetween(startDate,endDate);

        //初始化,约束
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> lists = goodsService.selectByExampleWithObject(example);
        //使用pageHelper的方式封装数据,默认的导航列表长度为8
        PageInfo pageInfo = new PageInfo(lists, 8);
        return MessageAndData.success("").add("pageInfo",pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/opt/{id}",method = RequestMethod.GET)
    public MessageAndData optSelectPrimaryKey(@PathVariable("id")Integer id){
        Goods obj = goodsService.selectByPrimaryKeyWithObject(id);
        return MessageAndData.success("查询成功").add("obj",obj);
    }


    @ResponseBody
    @RequestMapping(value = "/opt",method = RequestMethod.POST)
    public MessageAndData optInsert(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request, Goods obj) throws IOException {
        String path="c:\\upload";
//        String path = request.getSession().getServletContext().getRealPath("/images/upload");
        String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
        File file1 = new File(path, filename);
        if(!file1.exists()){
            file1.mkdirs();//迭代建立多级目录
        }
        file.transferTo(file1);
        String avatarUrl = "/upload/" + filename;
        obj.setGavatar(avatarUrl);

        Integer i = goodsService.insertSelective(obj);
        if(i>0){
            return MessageAndData.success("成功添加"+i+"条记录");
        }else{
            return MessageAndData.error("添加失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/opt/{ids}",method = RequestMethod.DELETE)
    public MessageAndData deletes(@PathVariable("ids")String ids){
        //获取传递过来的uid列表,分解为一个集合对象
        List<Integer> iIds = new ArrayList<Integer>();
        String splitSymbol = "\\D";
        String[] sIds = ids.split(splitSymbol);
        Integer i = null;
        for (String sId : sIds) {
            iIds.add(Integer.parseInt(sId));
        }
        if(iIds.size() > 1) {//删除多条记录
            //创建一个UserExample对象
            GoodsExample example = new GoodsExample();
            example.createCriteria().andGidIn(iIds);
            //执行批量删除
            i = goodsService.deleteByExample(example);
        }else{//删除一条记录
            i = goodsService.deleteByPrimaryKey(iIds.get(0));
        }
        return MessageAndData.success("删除成功"+i+"条记录").add("num", i);
    }


    //    如果使用put方法,记得要在web.xml中添加相应过滤器,对象不能封装
    @ResponseBody
    @RequestMapping(value = "/optu",method = RequestMethod.POST)
    public MessageAndData optUpdate(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request,Goods obj) throws IOException {
        String path="c:\\upload";
//        String path = request.getSession().getServletContext().getRealPath("/images/upload");
        String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
        File file1 = new File(path, filename);
        if(!file1.exists()){
            file1.mkdirs();
        }
        file.transferTo(file1);
        String avatarUrl = "/upload/" + filename;
        obj.setGavatar(avatarUrl);

        int i = goodsService.updateByPrimaryKeySelective(obj);
        if(i>0){
            return MessageAndData.success("成功修改"+i+"条记录");
        }else{
            return MessageAndData.error("修改失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/opt",method = RequestMethod.PUT, headers="content-type=multipart/form-data")
    public MessageAndData optUpdateRest(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request,Goods obj) throws IOException {
        String path="c:\\upload";
//        String path = request.getSession().getServletContext().getRealPath("/images/upload");
        String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
        File file1 = new File(path, filename);
        if(!file1.exists()){
            file1.mkdirs();
        }
        file.transferTo(file1);
        String avatarUrl = "/upload/" + filename;
        obj.setGavatar(avatarUrl);

        int i = goodsService.updateByPrimaryKeySelective(obj);
        if(i>0){
            return MessageAndData.success("成功修改"+i+"条记录");
        }else{
            return MessageAndData.error("修改失败");
        }
    }

}
