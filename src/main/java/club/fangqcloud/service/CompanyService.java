package club.fangqcloud.service;

import club.fangqcloud.pojo.Company;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface CompanyService {

    Boolean insert(Company company);

    List<Company> choiceAll();

    Boolean delete(String companyId);

    Boolean alter(Company company);


}
