package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.domain.Activity;
import vip.epss.domain.ActivityExample;
import vip.epss.service.ActivityService;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/27 0027
 * @描述
 */
@Service(value = "activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityService activityService;

    @Override
    public long countByExample(ActivityExample example) {
        return activityService.countByExample(example);
    }

    @Override
    public int deleteByExample(ActivityExample example) {
        return activityService.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer aid) {
        return activityService.deleteByPrimaryKey(aid);
    }

    @Override
    public int insert(Activity record) {
        return activityService.insert(record);
    }

    @Override
    public int insertSelective(Activity record) {
        return activityService.insertSelective(record);
    }

    @Override
    public List<Activity> selectByExample(ActivityExample example) {
        return activityService.selectByExample(example);
    }

    @Override
    public Activity selectByPrimaryKey(Integer aid) {
        return activityService.selectByPrimaryKey(aid);
    }

    @Override
    public int updateByExampleSelective(Activity record, ActivityExample example) {
        return activityService.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Activity record, ActivityExample example) {
        return activityService.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Activity record) {
        return activityService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Activity record) {
        return activityService.updateByPrimaryKey(record);
    }
}
