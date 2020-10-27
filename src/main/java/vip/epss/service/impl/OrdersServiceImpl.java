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
        return 0;
    }

    @Override
    public int deleteByExample(OrdersExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer oid) {
        return 0;
    }

    @Override
    public int insert(Orders record) {
        return 0;
    }

    @Override
    public int insertSelective(Orders record) {
        return 0;
    }

    @Override
    public List<Orders> selectByExample(OrdersExample example) {
        return null;
    }

    @Override
    public Orders selectByPrimaryKey(Integer oid) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Orders record, OrdersExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Orders record, OrdersExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return 0;
    }
}
