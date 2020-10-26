package vip.epss.service;

import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Goods;
import vip.epss.domain.GoodsExample;

import java.util.List;

public interface GoodsService {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer gid);

    List<Goods> selectByExampleWithObject(GoodsExample example);

    Goods selectByPrimaryKeyWithObject(Integer gid);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}
