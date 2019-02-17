package club.fangqcloud.service;

import club.fangqcloud.pojo.Person;
import club.fangqcloud.pojo.Worker;
import com.github.pagehelper.Page;

import java.util.List;

public interface WorkerService {
    
    Boolean create(Worker worker);
    
    Worker choiceByPrimaryKey(String openid);

    Page<Worker> selectAll();

    Boolean delete(String openid);

    Page<Worker> selectByName(String name);

    Boolean alter(Worker worker);
}
