package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Worker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerMapper {
    int deleteByPrimaryKey(String openid);

    int insert(Worker record);

    Worker selectByPrimaryKey(String openid);

    List<Worker> selectAll();

    int updateByPrimaryKey(Worker record);
}