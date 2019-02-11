package club.fangqcloud.impl;

import club.fangqcloud.mapper.InsuredMapper;
import club.fangqcloud.pojo.Insured;
import club.fangqcloud.service.InsuredService;
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
    public List<Insured> selectAll() {
        return insuredMapper.selectAll();
    }
}
