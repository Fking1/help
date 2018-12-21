package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Insured;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuredMapper {
    int deleteByPrimaryKey(String openid);

    int insert(Insured record);

    Insured selectByPrimaryKey(String openid);

    List<Insured> selectAll();

    int updateByPrimaryKey(Insured record);
    
    String selectOpenidById(String id);
}