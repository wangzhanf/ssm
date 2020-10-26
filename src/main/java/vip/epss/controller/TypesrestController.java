package vip.epss.controller;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.epss.domain.Types;
import vip.epss.service.TypesService;
import vip.epss.utils.MessageAndData;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/26 0026
 * @描述
 */
@Controller
@RequestMapping(value = "/types")
public class TypesrestController {
    @Autowired
    private TypesService typesService;

    @ResponseBody
    @RequestMapping(value = "/listJSON")
    public MessageAndData listJSON(){
        List<Types> lists = typesService.selectByExample(null);
        return MessageAndData.success("").add("lists",lists);
    }
}
