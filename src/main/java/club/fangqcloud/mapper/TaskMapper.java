package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    Task selectByPrimaryKey(String taskId);

    List<Task> selectAll();

    int updateByPrimaryKey(Task record);
    
    
//    新增接口
    List<Map> selectList(String state);
    
    List<Map> selectListByOpenid(String openid);

    String selectLastPrimaryKey(String current);
    
    int updateState(Task task);

    List<Task> selectByName(String name);
}