package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {

    int insert(Company record);

    List<Company> selectAll();

    Company selectByPrimaryKey(String companyId);

    int updateByPrimaryKey(Company record);

    int delete(String companyId);

}