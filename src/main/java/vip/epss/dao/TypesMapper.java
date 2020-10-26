package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Types;
import vip.epss.domain.TypesExample;

public interface TypesMapper {
    long countByExample(TypesExample example);

    int deleteByExample(TypesExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Types record);

    int insertSelective(Types record);

    List<Types> selectByExample(TypesExample example);

    Types selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Types record, @Param("example") TypesExample example);

    int updateByExample(@Param("record") Types record, @Param("example") TypesExample example);

    int updateByPrimaryKeySelective(Types record);

    int updateByPrimaryKey(Types record);
}