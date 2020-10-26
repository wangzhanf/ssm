package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
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
        return 0;
    }

    @Override
    public int deleteByExample(BusinessExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer bid) {
        return 0;
    }

    @Override
    public int insert(Business record) {
        return 0;
    }

    @Override
    public int insertSelective(Business record) {
        return 0;
    }

    @Override
    public List<Business> selectByExample(BusinessExample example) {
        return businessMapper.selectByExample(example);
    }

    @Override
    public Business selectByPrimaryKey(Integer bid) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Business record, BusinessExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Business record, BusinessExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Business record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Business record) {
        return 0;
    }
}
