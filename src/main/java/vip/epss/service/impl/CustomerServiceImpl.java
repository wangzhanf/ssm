package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.CustomerMapper;
import vip.epss.domain.Customer;
import vip.epss.domain.CustomerExample;
import vip.epss.service.CustomerService;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/27 0027
 * @描述
 */
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public long countByExample(CustomerExample example) {
        return customerMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CustomerExample example) {
        return customerMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer cid) {
        return customerMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int insert(Customer record) {
        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(Customer record) {
        return customerMapper.insertSelective(record);
    }

    @Override
    public List<Customer> selectByExample(CustomerExample example) {
        return customerMapper.selectByExample(example);
    }

    @Override
    public Customer selectByPrimaryKey(Integer cid) {
        return customerMapper.selectByPrimaryKey(cid);
    }

    @Override
    public int updateByExampleSelective(Customer record, CustomerExample example) {
        return customerMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Customer record, CustomerExample example) {
        return customerMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return customerMapper.updateByPrimaryKey(record);
    }
}
