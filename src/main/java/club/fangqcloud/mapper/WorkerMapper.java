package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Worker;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerMapper {
    int delete(String openid);

    int insert(Worker record);

    Worker selectByPrimaryKey(String openid);

    Page<Worker> selectAll();

    int update(Worker worker);

    Page<Worker> selectByName(String name);
}