package club.fangqcloud.service;

import club.fangqcloud.pojo.Insured;
import club.fangqcloud.pojo.Person;

public interface InsuredService {
    Insured choiceByPrimaryKey(String openid);
    
    Boolean create(Insured insured);
}
