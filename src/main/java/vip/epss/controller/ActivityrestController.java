package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.epss.service.ActivityService;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/26 0026
 * @描述
 */
@Controller
@RequestMapping(value = "/activity")
public class ActivityrestController {
    @Autowired
    private ActivityService activityService;


}