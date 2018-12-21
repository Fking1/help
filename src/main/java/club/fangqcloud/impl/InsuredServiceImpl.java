package club.fangqcloud.impl;

import club.fangqcloud.mapper.InsuredMapper;
import club.fangqcloud.pojo.Insured;
import club.fangqcloud.service.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuredServiceImpl implements InsuredService {
    
    @Autowired
    private InsuredMapper insuredMapper;
    
    @Override
    public Insured choiceByPrimaryKey(String openid) {
        return insuredMapper.selectByPrimaryKey(openid);
    }
}
