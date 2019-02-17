package club.fangqcloud.service;

import club.fangqcloud.pojo.Insured;
import club.fangqcloud.pojo.Person;
import com.github.pagehelper.Page;

import java.util.List;

public interface InsuredService {
    Insured choiceByPrimaryKey(String openid);
    
    Boolean create(Insured insured);

    Page<Insured> selectAll();

    Boolean delete(String openid);

    Page<Insured> selectByName(String name);

    Boolean alter(Insured insured);
}
