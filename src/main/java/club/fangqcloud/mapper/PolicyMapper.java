package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Policy;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PolicyMapper {
    int deleteByPrimaryKey(String policyId);

    int insert(Policy record);

    Policy selectByPrimaryKey(String policyId);

    List<Policy> selectAll();

    int updateByPrimaryKey(Policy record);
}