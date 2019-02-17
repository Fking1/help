package club.fangqcloud.impl;

import club.fangqcloud.mapper.WorkerMapper;
import club.fangqcloud.pojo.Person;
import club.fangqcloud.pojo.Worker;
import club.fangqcloud.service.WorkerService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper workerMapper;
    
    @Override
    public Boolean create(Worker worker) {
        if(workerMapper.insert(worker)>0){
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
    public Page<Worker> selectAll() {
        return workerMapper.selectAll();
    }

    @Override
    public Boolean delete(String openid) {
        if(workerMapper.delete(openid)>0)
            return true;
        else
            return false;
    }

    @Override
    public Page<Worker> selectByName(String name) {
        return workerMapper.selectByName(name);
    }

    @Override
    public Boolean alter(Worker worker) {
        if(workerMapper.update(worker)>0){
            return true;
        }
        else{
            return false;
        }
    }
}
