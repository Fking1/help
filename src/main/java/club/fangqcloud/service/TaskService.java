package club.fangqcloud.service;

import club.fangqcloud.pojo.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {
    List<Map> choiceList();
    
    List<Map> choiceListByOpenid(String openid);
    
    Boolean create(Map<String,String> taskInfo);
    
    String choiceLastPrimaryKey();
    
    Boolean changeByPrimaryKey(Task task);
}
