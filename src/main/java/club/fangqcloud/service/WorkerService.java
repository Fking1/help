package club.fangqcloud.service;

import club.fangqcloud.pojo.Person;
import club.fangqcloud.pojo.Worker;

import java.util.List;

public interface WorkerService {
    
    Boolean create(Person person);
    
    Worker choiceByPrimaryKey(String openid);
    
    
}
