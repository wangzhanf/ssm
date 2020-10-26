package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.epss.domain.Types;
import vip.epss.service.TypesService;
import vip.epss.utils.MessageAndData;

import java.util.List;

@RestController
@RequestMapping(value = "/types")
public class TypesController {

    @Autowired
    private TypesService typesService;

    @GetMapping(value = "/list")
    public MessageAndData list(){
        List<Types> types = typesService.selectByExample(null);
        return MessageAndData.success("").add("types",types);
    }
}
