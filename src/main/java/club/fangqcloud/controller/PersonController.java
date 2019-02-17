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
    
    @RequestMapping("/getByPrimaryKey.do")
    @ResponseBody
    public Person getByPrimaryKey(String openid){
        Insured insured = insuredService.choiceByPrimaryKey(openid);
        Worker worker = workerService.choiceByPrimaryKey(openid);
    
        if(insured != null)
            return insured;
        else if(worker != null)
            return worker;
        else
            return null;
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

        if(person.getPersonType().equals("投保人") || person.getPersonType().equals("被保人")){
            Insured insured = new Insured();
            insured.setOpenid(person.getOpenid());
            insured.setId(person.getId());
            insured.setName(person.getName());
            insured.setSex(person.getSex());
            insured.setAddress(person.getAddress());
            insured.setHealthState(person.getHealthState());
            insured.setCode(person.getCode());
            insured.setTelephone(person.getTelephone());
            insured.setAvatarUrl("http://120.79.227.155:8080/"+filename);
            insured.setPersonType(person.getPersonType());
            return insuredService.create(insured);
        }
        else{
            Worker worker = new Worker();
            worker.setOpenid(person.getOpenid());
            worker.setId(person.getId());
            worker.setName(person.getName());
            worker.setSex(person.getSex());
            worker.setAddress(person.getAddress());
            worker.setHealthState(person.getHealthState());
            worker.setCode(person.getCode());
            worker.setTelephone(person.getTelephone());
            worker.setAvatarUrl("http://120.79.227.155:8080/"+filename);
            worker.setServiceState("空闲");
            worker.setPersonType(person.getPersonType());
            return workerService.create(worker);
        }
    }
    
}
