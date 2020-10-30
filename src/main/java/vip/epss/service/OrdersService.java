package vip.epss.service;

import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Orders;
import vip.epss.domain.OrdersExample;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/27 0027
 * @描述
 */
public interface OrdersService {
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> selectByExampleWithObject(OrdersExample example);

    Orders selectByPrimaryKeyWithObject(Integer oid);
}
