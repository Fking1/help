package club.fangqcloud.controller;

import club.fangqcloud.pojo.Worker;
import club.fangqcloud.service.WorkerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Controller
@RequestMapping("/worker")
public class WorkController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping("/getAll.do")
    @ResponseBody
    public PageInfo<Worker> getAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "5") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Worker> pageInfo = new PageInfo<>(workerService.selectAll());
        return pageInfo;
    }


    @RequestMapping(value = "/remove.do",method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean delete(String openid){
        return workerService.delete(openid);
    }

    @RequestMapping("/getByName.do")
    @ResponseBody
    public PageInfo<Worker> getByName(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "3") int pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Worker> pageInfo = new PageInfo<>(workerService.selectByName(name));
        return pageInfo;
    }

    @RequestMapping("/modify.do")
    @ResponseBody
    public Boolean modify(MultipartFile logo, String openid, String id, String name, String sex, String code, String telephone, String address, String healthState, String serviceState, String personType, Integer monthServiceHours, Integer wholeServiceHours){
        Worker worker = new Worker();
        if(logo==null){

        }else{
            String filename = logo.getOriginalFilename();
            File dest = new File(System.getProperty("user.dir")+"/upload/"+filename);
            worker.setAvatarUrl("http://120.79.227.155:8080/"+filename);
        }

        worker.setOpenid(openid);
        worker.setId(id);
        worker.setName(name);
        worker.setSex(sex);
        worker.setCode(code);
        worker.setTelephone(telephone);
        worker.setAddress(address);
        worker.setHealthState(healthState);
        worker.setPersonType(personType);

        worker.setServiceState(serviceState);
        worker.setMonthServiceHours(monthServiceHours);
        worker.setWholeServiceHours(wholeServiceHours);

        return workerService.alter(worker);
    }


    @RequestMapping("/add.do")
    @ResponseBody
    public Boolean add(MultipartFile logo, String openid, String id, String name, String sex, String code, String telephone, String address, String healthState, String serviceState, String personType, Integer monthServiceHours, Integer wholeServiceHours){
        Worker worker = new Worker();
        if(logo==null){

        }else{
            String filename = logo.getOriginalFilename();
            File dest = new File(System.getProperty("user.dir")+"/upload/"+filename);
            worker.setAvatarUrl("http://120.79.227.155:8080/"+filename);
        }

        worker.setOpenid(openid);
        worker.setId(id);
        worker.setName(name);
        worker.setSex(sex);
        worker.setCode(code);
        worker.setTelephone(telephone);
        worker.setAddress(address);
        worker.setHealthState(healthState);
        worker.setPersonType(personType);

        worker.setServiceState(serviceState);
        worker.setMonthServiceHours(monthServiceHours);
        worker.setWholeServiceHours(wholeServiceHours);

        return workerService.create(worker);
    }


}
