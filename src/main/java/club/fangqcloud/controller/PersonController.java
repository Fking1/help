package club.fangqcloud.controller;

import club.fangqcloud.pojo.Person;
import club.fangqcloud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    
    @RequestMapping("/addPerson.do")
    @ResponseBody
    public Boolean addPerson(@RequestParam("avatar") MultipartFile file,Person person) throws IOException {
        String filename = file.getOriginalFilename();
        String pa = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(pa);
        
        File dest = new File(System.getProperty("user.dir")+"/upload/"+filename);
        file.transferTo(dest);
        person.setAvatarUrl("http://120.79.227.155:8080/help/"+filename);
        return personService.create(person);
    }
}
