package club.fangqcloud.controller;

import club.fangqcloud.pojo.Policy;
import club.fangqcloud.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    private PolicyService policyService;
    
    @RequestMapping("/getEffectPolicyByOpenid.do")
    @ResponseBody
    List<Policy> getEffectPolicyByOpenid(String openid){
        return policyService.choiceEffectByOpenid(openid);
    }
}
