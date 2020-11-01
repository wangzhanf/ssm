package vip.epss.service;

import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Business;
import vip.epss.domain.BusinessExample;

import java.util.List;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/26 0026
 * @描述
 */
public interface BusinessService {
    long countByExample(BusinessExample example);

    int deleteByExample(BusinessExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Business record);

    int insertSelective(Business record);

    List<Business> selectByExample(BusinessExample example);

    Business selectByPrimaryKey(Integer bid);

    List<Business> selectByExampleWithObject(BusinessExample example);

    Business selectByPrimaryKeyWithObject(Integer bid);

    int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);

    int updateStatus(Integer bid,Integer aid,Boolean status);
}
