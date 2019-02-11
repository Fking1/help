package club.fangqcloud.impl;

import club.fangqcloud.mapper.WorkerMapper;
import club.fangqcloud.pojo.Person;
import club.fangqcloud.pojo.Worker;
import club.fangqcloud.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper workerMapper;
    
    @Override
    public Boolean create(Person person) {
        if(workerMapper.insert((Worker)person)>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public Worker choiceByPrimaryKey(String openid) {
        return workerMapper.selectByPrimaryKey(openid);
    }

    @Override
    public List<Worker> selectAll() {
        return workerMapper.selectAll();
    }
}
