package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Insured;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuredMapper {
    int deleteByPrimaryKey(String openid);

    int insert(Insured record);

    Insured selectByPrimaryKey(String openid);


    int updateByPrimaryKey(Insured record);
    
    //新增接口
    
    String selectOpenidById(String id);

    Page<Insured> selectAll();

    Page<Insured> selectByName(String name);
}