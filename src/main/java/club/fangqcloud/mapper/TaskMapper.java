package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Task;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TaskMapper {
    int delete(String taskId);

    int insert(Task record);

    Task selectByPrimaryKey(String taskId);

    Page<Task> selectAll();

    int updateByPrimaryKey(Task record);
    
    
//    新增接口
    List<Map> selectList(String taskState);
    
    List<Map> selectListByOpenid(String openid);

    String selectLastPrimaryKey(String current);
    
    int updateState(Task task);

    Page<Task> selectByTaskId(String taskId);
}