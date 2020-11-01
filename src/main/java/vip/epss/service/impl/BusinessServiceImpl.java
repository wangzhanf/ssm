package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.BusinessMapper;
import vip.epss.dao.BusinessToActivityMapper;
import vip.epss.dao.GoodsMapper;
import vip.epss.dao.OrdersMapper;
import vip.epss.domain.*;
import vip.epss.service.BusinessService;
import vip.epss.utils.MD5Util;

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
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private BusinessToActivityMapper businessToActivityMapper;


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
        //删除对应的订单
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andFbidEqualTo(bid);
        ordersMapper.deleteByExample(ordersExample);
        //删除商户对应的商品
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andFbidEqualTo(bid);
        goodsMapper.deleteByExample(goodsExample);
        //删除商户对应的活动列表内容
        BusinessToActivityExample businessToActivityExample = new BusinessToActivityExample();
        businessToActivityExample.createCriteria().andFbidEqualTo(bid);
        businessToActivityMapper.deleteByExample(businessToActivityExample);
        //删除商户
        return businessMapper.deleteByPrimaryKey(bid);
    }

    @Override
    public int insert(Business record) {
        record.setBpass(MD5Util.getMD5(record.getBpass()));
        return businessMapper.insert(record);
    }

    @Override
    public int insertSelective(Business record) {
        record.setBpass(MD5Util.getMD5(record.getBpass()));
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
    public List<Business> selectByExampleWithObject(BusinessExample example) {
        return businessMapper.selectByExampleWithObject(example);
    }

    @Override
    public Business selectByPrimaryKeyWithObject(Integer bid) {
        return businessMapper.selectByPrimaryKeyWithObject(bid);
    }

    @Override
    public int updateByExampleSelective(Business record, BusinessExample example) {
        record.setBpass(MD5Util.getMD5(record.getBpass()));
        return businessMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Business record, BusinessExample example) {
        record.setBpass(MD5Util.getMD5(record.getBpass()));
        return businessMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Business record) {
        record.setBpass(MD5Util.getMD5(record.getBpass()));
        return businessMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Business record) {
        record.setBpass(MD5Util.getMD5(record.getBpass()));
        return businessMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateStatus(Integer bid, Integer aid, Boolean status) {

        if(status){//如果为true则关闭该活动
            BusinessToActivityExample businessToActivityExample = new BusinessToActivityExample();
            businessToActivityExample.createCriteria().andFbidEqualTo(bid).andFaidEqualTo(aid);
            businessToActivityMapper.deleteByExample(businessToActivityExample);
        }else{
            BusinessToActivity businessToActivity = new BusinessToActivity();
            businessToActivity.setFaid(aid);
            businessToActivity.setFbid(bid);
            businessToActivityMapper.insertSelective(businessToActivity);
        }
        return 0;
    }
}
