package club.fangqcloud.controller;

import club.fangqcloud.pojo.Company;
import club.fangqcloud.service.CompanyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public List<Company> getAll(){
        return companyService.choiceAll();
    }

    @RequestMapping("/remove.do")
    @ResponseBody
    public Boolean remove(String companyId){
        return companyService.delete(companyId);
    }

    @RequestMapping("/change.do")
    @ResponseBody
    public Boolean change(Company company){
        return companyService.alter(company);
    }
}
