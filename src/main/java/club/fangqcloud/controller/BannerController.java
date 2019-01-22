package club.fangqcloud.controller;

import club.fangqcloud.pojo.Banner;
import club.fangqcloud.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/getAll.do")
    @ResponseBody
    public List<Banner> getAll(){
        return bannerService.choiceAll();
    }
}
