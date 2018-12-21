package club.fangqcloud.controller;

import club.fangqcloud.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    
    @RequestMapping("/login.do")
    @ResponseBody
    public String login(String code){
        return loginService.login(code);
    }
}
