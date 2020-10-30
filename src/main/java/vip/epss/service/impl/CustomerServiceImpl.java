package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.CustomerMapper;
import vip.epss.dao.OrdersMapper;
import vip.epss.domain.Customer;
import vip.epss.domain.CustomerExample;
import vip.epss.domain.OrdersExample;
import vip.epss.service.CustomerService;
import vip.epss.utils.MD5Util;

import java.util.ArrayList;
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
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public long countByExample(CustomerExample example) {
        return customerMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CustomerExample example) {
        return customerMapper.deleteByExample(example);
    }

    @Override
    public int deleteByExample(CustomerExample example, List<Integer> ids) {
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andFcidIn(ids);
        ordersMapper.deleteByExample(ordersExample);
        return customerMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer cid) {
        //如果删除用户，首先应该删除该用户的所有订单
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andFcidEqualTo(cid);
        ordersMapper.deleteByExample(example);
        return customerMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int insert(Customer record) {
        record.setCpass(MD5Util.getMD5(record.getCpass()));
        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(Customer record) {
        record.setCpass(MD5Util.getMD5(record.getCpass()));
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
        record.setCpass(MD5Util.getMD5(record.getCpass()));
        return customerMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        record.setCpass(MD5Util.getMD5(record.getCpass()));
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        record.setCpass(MD5Util.getMD5(record.getCpass()));
        return customerMapper.updateByPrimaryKey(record);
    }
}
