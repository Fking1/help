package club.fangqcloud.controller;

import club.fangqcloud.mapper.InsuredMapper;
import club.fangqcloud.pojo.Insured;
import club.fangqcloud.service.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/insured")
public class InsuredController {
    
    @Autowired
    private InsuredService insuredService;
    
    @RequestMapping("/getInsuredByPrimaryKey.do")
    @ResponseBody
    public Insured getInsuredByPrimaryKey(String openid){
        return insuredService.choiceByPrimaryKey(openid);
    }
}
