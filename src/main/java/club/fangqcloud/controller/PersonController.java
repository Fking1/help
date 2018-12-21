package club.fangqcloud.controller;

import club.fangqcloud.pojo.Person;
import club.fangqcloud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    
    @RequestMapping("/getPersonByPrimaryKey.do")
    @ResponseBody
    public Person getPersonByPrimaryKey(String openid){
        return personService.choiceByPrimaryKey(openid);
    }
    
}
