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
    
    
    List<Map> selectList();
    
    List<Map> selectListByOpenid(String openid);
    
//    String selectOpenidById(String id);
    
    String selectLastPrimaryKey(String current);
}