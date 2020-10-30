package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.BusinessMapper;
import vip.epss.domain.Business;
import vip.epss.domain.BusinessExample;
import vip.epss.service.BusinessService;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/26 0026
 * @描述
 */
@Service(value = "businessService")
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public long countByExample(BusinessExample example) {
        return businessMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(BusinessExample example) {
        return businessMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer bid) {
        return businessMapper.deleteByPrimaryKey(bid);
    }

    @Override
    public int insert(Business record) {
        return businessMapper.insert(record);
    }

    @Override
    public int insertSelective(Business record) {
        return businessMapper.insertSelective(record);
    }

    @Override
    public List<Business> selectByExample(BusinessExample example) {
        return businessMapper.selectByExample(example);
    }

    @Override
    public Business selectByPrimaryKey(Integer bid) {
        return businessMapper.selectByPrimaryKey(bid);
    }

    @Override
    public int updateByExampleSelective(Business record, BusinessExample example) {
        return businessMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Business record, BusinessExample example) {
        return businessMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Business record) {
        return businessMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Business record) {
        return businessMapper.updateByPrimaryKey(record);
    }
}
