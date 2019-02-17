package club.fangqcloud.controller;

import club.fangqcloud.pojo.Insured;
import club.fangqcloud.service.InsuredService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    public PageInfo<Insured> getAll(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "3") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Insured> pageInfo = new PageInfo<>(insuredService.selectAll());
        return pageInfo;
    }

    @RequestMapping("/remove.do")
    @ResponseBody
    public Boolean remove(String openid){
        return insuredService.delete(openid);
    }

    @RequestMapping("/getByName.do")
    @ResponseBody
    public PageInfo<Insured> getByName(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "3") int pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Insured> pageInfo = new PageInfo<>(insuredService.selectByName(name));
        return pageInfo;
    }


    @RequestMapping("/modify.do")
    @ResponseBody
    public Boolean modify(MultipartFile logo, String openid, String id, String name, String sex, String code, String telephone, String address, String healthState, String personType){
        Insured insured = new Insured();
        if(logo==null){

        }else{
            String filename = logo.getOriginalFilename();
            File dest = new File(System.getProperty("user.dir")+"/upload/"+filename);
            insured.setAvatarUrl("http://120.79.227.155:8080/"+filename);
        }

        insured.setOpenid(openid);
        insured.setId(id);
        insured.setName(name);
        insured.setSex(sex);
        insured.setCode(code);
        insured.setTelephone(telephone);
        insured.setAddress(address);
        insured.setHealthState(healthState);
        insured.setPersonType(personType);


        return insuredService.alter(insured);
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public Boolean add(MultipartFile logo, String openid, String id, String name, String sex, String code, String telephone, String address, String healthState, String personType){
        Insured insured = new Insured();
        if(logo==null){

        }else{
            String filename = logo.getOriginalFilename();
            File dest = new File(System.getProperty("user.dir")+"/upload/"+filename);
            insured.setAvatarUrl("http://120.79.227.155:8080/"+filename);
        }

        insured.setOpenid(openid);
        insured.setId(id);
        insured.setName(name);
        insured.setSex(sex);
        insured.setCode(code);
        insured.setTelephone(telephone);
        insured.setAddress(address);
        insured.setHealthState(healthState);
        insured.setPersonType(personType);


        return insuredService.create(insured);
    }

}
