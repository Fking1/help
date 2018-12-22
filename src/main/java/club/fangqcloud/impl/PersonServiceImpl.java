package club.fangqcloud.impl;

import club.fangqcloud.mapper.PersonMapper;
import club.fangqcloud.pojo.Person;
import club.fangqcloud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    private PersonMapper personMapper;
    
    @Override
    public Person choiceByPrimaryKey(String openid) {
        return personMapper.selectByPrimaryKey(openid);
    }
    
    @Override
    public Boolean create(Person person) {
        if(personMapper.insert(person)>0)
            return true;
        else
            return false;
    }
}
