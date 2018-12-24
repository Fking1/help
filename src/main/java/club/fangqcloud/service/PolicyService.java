package club.fangqcloud.service;

import club.fangqcloud.pojo.Policy;

import java.util.List;

public interface PolicyService {
    List<Policy> choiceEffectByOpenid(String openid);
}
