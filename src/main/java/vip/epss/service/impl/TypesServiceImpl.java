package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.TypesMapper;
import vip.epss.domain.Types;
import vip.epss.domain.TypesExample;
import vip.epss.service.TypesService;

import java.util.List;

@Service(value = "typesService")
public class TypesServiceImpl implements TypesService {

    @Autowired
    private TypesMapper typesMapper;

    @Override
    public long countByExample(TypesExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(TypesExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer tid) {
        return 0;
    }

    @Override
    public int insert(Types record) {
        return 0;
    }

    @Override
    public int insertSelective(Types record) {
        return 0;
    }

    @Override
    public List<Types> selectByExample(TypesExample example) {
        return typesMapper.selectByExample(example);
    }

    @Override
    public Types selectByPrimaryKey(Integer tid) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Types record, TypesExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Types record, TypesExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Types record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Types record) {
        return 0;
    }
}
