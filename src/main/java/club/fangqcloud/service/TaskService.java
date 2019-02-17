package club.fangqcloud.service;

import club.fangqcloud.pojo.Task;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface TaskService {
    List<Map> choiceList(String state);
    
    List<Map> choiceListByOpenid(String openid);
    
    Boolean add(Map<String,String> taskInfo);
    
    String choiceLastPrimaryKey();
    
    Boolean changeState(Task task);
    
    Boolean changeByPrimaryKey(Task taskInfo);

    Page<Task> choiceAll();

    Page<Task> selectByTaskId(String taskId);

    Boolean insert(Task task);

    Boolean delete(String taskId);
    
}
