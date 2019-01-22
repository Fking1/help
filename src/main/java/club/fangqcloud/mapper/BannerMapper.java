package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {

    List<Banner> selectAll();
}
