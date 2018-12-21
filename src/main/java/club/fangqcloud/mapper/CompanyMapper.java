package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyMapper {
    int deleteByPrimaryKey(String companyId);

    int insert(Company record);

    Company selectByPrimaryKey(String companyId);

    List<Company> selectAll();

    int updateByPrimaryKey(Company record);
}