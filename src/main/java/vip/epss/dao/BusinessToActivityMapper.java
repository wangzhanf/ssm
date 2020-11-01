package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.BusinessToActivity;
import vip.epss.domain.BusinessToActivityExample;

public interface BusinessToActivityMapper {
    long countByExample(BusinessToActivityExample example);

    int deleteByExample(BusinessToActivityExample example);

    int deleteByPrimaryKey(Integer baid);

    int insert(BusinessToActivity record);

    int insertSelective(BusinessToActivity record);

    List<BusinessToActivity> selectByExample(BusinessToActivityExample example);

    BusinessToActivity selectByPrimaryKey(Integer baid);

    int updateByExampleSelective(@Param("record") BusinessToActivity record, @Param("example") BusinessToActivityExample example);

    int updateByExample(@Param("record") BusinessToActivity record, @Param("example") BusinessToActivityExample example);

    int updateByPrimaryKeySelective(BusinessToActivity record);

    int updateByPrimaryKey(BusinessToActivity record);
}