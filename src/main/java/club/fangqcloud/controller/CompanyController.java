package club.fangqcloud.controller;

import club.fangqcloud.pojo.Company;
import club.fangqcloud.pojo.Task;
import club.fangqcloud.service.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/add.do")
    @ResponseBody
    public Boolean add(Company company){
        return companyService.insert(company);
    }

    @RequestMapping("/getAll.do")
    @ResponseBody
    public PageInfo<Company> getAll(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "3") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Company> pageInfo = new PageInfo<>(companyService.choiceAll());
        return pageInfo;
    }

    @RequestMapping("/remove.do")
    @ResponseBody
    public Boolean remove(String companyId){
        return companyService.delete(companyId);
    }

    @RequestMapping("/modify.do")
    @ResponseBody
    public Boolean modify(MultipartFile logo,String companyId,String companyName,String contactName,String telephone,String address,String companyType){
        Company company = new Company();
        if(logo==null){

        }else{
            String filename = logo.getOriginalFilename();
            File dest = new File(System.getProperty("user.dir")+"/upload/"+filename);
            company.setLogo("http://120.79.227.155:8080/"+filename);
        }

        company.setCompanyId(companyId);
        company.setCompanyName(companyName);
        company.setContactName(contactName);
        company.setTelephone(telephone);
        company.setCompanyAddress(address);
        company.setCompanyType(companyType);
        return companyService.alter(company);
    }

    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    @ResponseBody
    public Boolean upload(@RequestParam(value="logo")MultipartFile logo,String companyId,String companyName,String contactName,String telephone,String address,String companyType){
        String filename = logo.getOriginalFilename();

        File dest = new File(System.getProperty("user.dir")+"/upload/"+filename);
        Company company = new Company();
        company.setCompanyId(companyId);
        company.setCompanyName(companyName);
        company.setContactName(contactName);
        company.setTelephone(telephone);
        company.setCompanyAddress(address);
        company.setCompanyType(companyType);
        company.setLogo("http://120.79.227.155:8080/"+filename);
        return companyService.insert(company);
    }


    @RequestMapping("/getByCompanyName.do")
    @ResponseBody
    public PageInfo<Company> getByCompanyName(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "3") int pageSize, String companyName){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Company> pageInfo = new PageInfo<>(companyService.selectByCompanyName(companyName));
        return pageInfo;
    }
}
