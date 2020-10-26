package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.epss.domain.Business;
import vip.epss.service.BusinessService;
import vip.epss.utils.MessageAndData;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/26 0026
 * @描述
 */
@Controller
@RequestMapping(value = "/business")
public class BusinessrestController {

    @Autowired
    private BusinessService businessService;

    @ResponseBody
    @RequestMapping(value = "/listJSON")
    public MessageAndData listJSON(){
        List<Business> lists = businessService.selectByExample(null);
        return MessageAndData.success("").add("lists",lists);
    }
}
