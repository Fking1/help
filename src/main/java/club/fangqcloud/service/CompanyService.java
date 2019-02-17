package club.fangqcloud.service;

import club.fangqcloud.pojo.Company;
import com.github.pagehelper.Page;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface CompanyService {

    Boolean insert(Company company);

    Page<Company> choiceAll();

    Boolean delete(String companyId);

    Boolean alter(Company company);

    Page selectByCompanyName(String companyName);

}
