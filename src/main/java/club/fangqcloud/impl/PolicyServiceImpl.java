package club.fangqcloud.impl;

import club.fangqcloud.mapper.PolicyMapper;
import club.fangqcloud.pojo.Policy;
import club.fangqcloud.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyMapper policyMapper;
    
    @Override
    public List<Policy> choiceEffectByOpenid(String openid) {
        return policyMapper.selectEffectByOpenid(openid);
    }
}
