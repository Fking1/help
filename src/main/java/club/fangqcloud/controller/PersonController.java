package club.fangqcloud.controller;

import club.fangqcloud.pojo.Insured;
import club.fangqcloud.pojo.Person;
import club.fangqcloud.pojo.Worker;
import club.fangqcloud.service.InsuredService;
import club.fangqcloud.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Person类 为Insured,Worker的父类  对person的请求进行分发  发给Insured和Worker
 */

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private InsuredService insuredService;
    
    @Autowired
    private WorkerService workerService;
    
    @RequestMapping("/getPersonByPrimaryKey.do")
    @ResponseBody
    public Person getPersonByPrimaryKey(String openid){
        Insured insured = insuredService.choiceByPrimaryKey(openid);
        Worker worker = workerService.choiceByPrimaryKey(openid);
    
        if(insured!=null)
            return insured;
        else
            return worker;
    }
    
    /**
     * 根据personType判断存储什么类型的人员 再进行分发
     * @param file
     * @param person
     * @return Boolean 是否成功
     * @throws IOException
     */
    @RequestMapping("/addPerson.do")
    @ResponseBody
    public Boolean addPerson(@RequestParam("avatar") MultipartFile file,Person person) throws IOException {
        String filename = file.getOriginalFilename();
        
        File dest = new File(System.getProperty("user.dir")+"/upload/"+filename);
        file.transferTo(dest);
        person.setAvatarUrl("http://120.79.227.155:8080/help/"+filename);
        if(person.getPersonType()=="投保人" || person.getPersonType()=="被保人"){
            return insuredService.create((Insured)person);
        }
        else{
            return workerService.create((Worker)person);
        }
    }
    
}
