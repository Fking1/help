package club.fangqcloud.controller;

import club.fangqcloud.pojo.Insured;
import club.fangqcloud.service.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/insured")
public class InsuredController{
    
    @Autowired
    private InsuredService insuredService;
    
    @RequestMapping("/getInsuredByPrimaryKey.do")
    @ResponseBody
    public Insured getInsuredByPrimaryKey(String openid){
        return insuredService.choiceByPrimaryKey(openid);
    }

    @RequestMapping("/getAll.do")
    @ResponseBody
    public List<Insured> getAll(){
        return insuredService.selectAll();
    }
}
