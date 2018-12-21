package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonMapper {
    int deleteByPrimaryKey(String openid);

    int insert(Person record);

    Person selectByPrimaryKey(String openid);

    List<Person> selectAll();

    int updateByPrimaryKey(Person record);
}