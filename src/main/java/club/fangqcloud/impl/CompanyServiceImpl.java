package club.fangqcloud.impl;

import club.fangqcloud.mapper.CompanyMapper;
import club.fangqcloud.pojo.Company;
import club.fangqcloud.service.CompanyService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public Boolean insert(Company company){
        if(companyMapper.insert(company)>0){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public Page<Company> choiceAll() {
        return companyMapper.selectAll();
    }


    @Override
    public Boolean alter(Company company) {
        if(companyMapper.updateByPrimaryKey(company)>0){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public Boolean delete(String companyId) {
        if(companyMapper.delete(companyId)>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Page selectByCompanyName(String companyName) {
        return companyMapper.selectByCompanyName(companyName);
    }
}
