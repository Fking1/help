package club.fangqcloud.impl;

import club.fangqcloud.mapper.BannerMapper;
import club.fangqcloud.pojo.Banner;
import club.fangqcloud.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> choiceAll() {
        return bannerMapper.selectAll();
    }
}
