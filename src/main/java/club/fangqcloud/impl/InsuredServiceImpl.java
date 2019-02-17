package club.fangqcloud.impl;

import club.fangqcloud.mapper.InsuredMapper;
import club.fangqcloud.pojo.Insured;
import club.fangqcloud.service.InsuredService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InsuredServiceImpl implements InsuredService {
    
    @Autowired
    private InsuredMapper insuredMapper;
    
    @Override
    public Insured choiceByPrimaryKey(String openid) {
        return insuredMapper.selectByPrimaryKey(openid);
    }
    
    @Override
    public Boolean create(Insured insured) {
        if(insuredMapper.insert(insured)>0)
            return true;
        else return false;
    }

    @Override
    public Page<Insured> selectAll() {
        return insuredMapper.selectAll();
    }


    @Override
    public Boolean delete(String openid) {
        if(insuredMapper.deleteByPrimaryKey(openid)>0)
            return true;
        else
            return false;
    }

    @Override
    public Page<Insured> selectByName(String name) {
        return insuredMapper.selectByName(name);
    }

    @Override
    public Boolean alter(Insured insured) {
        if(insuredMapper.updateByPrimaryKey(insured)>0){
            return true;
        }
        else{
            return false;
        }
    }
}
