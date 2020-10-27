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
        return typesMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TypesExample example) {
        return typesMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer tid) {
        return typesMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(Types record) {
        return typesMapper.insert(record);
    }

    @Override
    public int insertSelective(Types record) {
        return typesMapper.insertSelective(record);
    }

    @Override
    public List<Types> selectByExample(TypesExample example) {
        return typesMapper.selectByExample(example);
    }

    @Override
    public Types selectByPrimaryKey(Integer tid) {
        return typesMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByExampleSelective(Types record, TypesExample example) {
        return typesMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Types record, TypesExample example) {
        return typesMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Types record) {
        return typesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Types record) {
        return typesMapper.updateByPrimaryKey(record);
    }
}
