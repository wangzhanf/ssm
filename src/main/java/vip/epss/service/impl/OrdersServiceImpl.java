package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.OrdersMapper;
import vip.epss.domain.Orders;
import vip.epss.domain.OrdersExample;
import vip.epss.service.OrdersService;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/27 0027
 * @描述
 */
@Service(value = "ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public long countByExample(OrdersExample example) {
        return ordersMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrdersExample example) {



        return ordersMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer oid) {
        return ordersMapper.deleteByPrimaryKey(oid);
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    @Override
    public int insertSelective(Orders record) {
        return ordersMapper.insertSelective(record);
    }

    @Override
    public List<Orders> selectByExample(OrdersExample example) {
        return ordersMapper.selectByExample(example);
    }

    @Override
    public Orders selectByPrimaryKey(Integer oid) {
        return ordersMapper.selectByPrimaryKey(oid);
    }

    @Override
    public int updateByExampleSelective(Orders record, OrdersExample example) {
        return ordersMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Orders record, OrdersExample example) {
        return ordersMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return ordersMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Orders> selectByExampleWithObject(OrdersExample example) {
        return ordersMapper.selectByExampleWithObject(example);
    }

    @Override
    public Orders selectByPrimaryKeyWithObject(Integer oid){
        return ordersMapper.selectByPrimaryKeyWithObject(oid);
    }
}
