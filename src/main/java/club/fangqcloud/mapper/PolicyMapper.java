package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Policy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PolicyMapper {
    int deleteByPrimaryKey(String policyId);

    int insert(Policy record);

    Policy selectByPrimaryKey(String policyId);

    List<Policy> selectAll();

    int updateByPrimaryKey(Policy record);
    
//    新增接口
    List<Map> selectListByOpenid(String openid);
    
//    查询用户有效的保单
    List<Policy> selectEffectByOpenid(String openid);
}