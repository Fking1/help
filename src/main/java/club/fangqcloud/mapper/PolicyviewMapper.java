package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Policyview;
import java.util.List;

public interface PolicyviewMapper {
    int insert(Policyview record);

    List<Policyview> selectAll();
}