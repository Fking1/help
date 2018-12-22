package club.fangqcloud.service;

import club.fangqcloud.pojo.Person;

public interface PersonService {
    Person choiceByPrimaryKey(String openid);
    
    Boolean create(Person person);
}
