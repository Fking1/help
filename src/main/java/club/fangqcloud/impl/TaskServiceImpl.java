package club.fangqcloud.impl;

import club.fangqcloud.mapper.InsuredMapper;
import club.fangqcloud.mapper.TaskMapper;
import club.fangqcloud.pojo.Task;
import club.fangqcloud.service.TaskService;
import club.fangqcloud.tools.PrimaryGenerater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskMapper taskMapper;
    
    @Autowired
    private InsuredMapper insuredMapper;
    
    @Override
    public List<Map> choiceList(String state) {
        return taskMapper.selectList(state);
    }
    
    @Override
    public List<Map> choiceListByOpenid(String openid) {
        return taskMapper.selectListByOpenid(openid);
    }
    
    @Override
    public Boolean create(Map<String,String> taskInfo) {
        Task task = new Task();
        PrimaryGenerater primaryGenerater = PrimaryGenerater.getInstance();
        String taskId = primaryGenerater.generaterNextNumber(choiceLastPrimaryKey());

        String openid1 = insuredMapper.selectOpenidById(taskInfo.get("id"));
        if(openid1!=null){
            task.setOpenid1(openid1);
            task.setTaskId(taskId);
            task.setContent(taskInfo.get("content"));
            task.setDescription(taskInfo.get("description"));
            task.setOpenid(taskInfo.get("openid"));
            task.setTaskState("约单");
            task.setPolicyId(taskInfo.get("policyId"));
            task.setOpenid2(null);
            task.setComments(null);
            task.setStar(null);

            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = simpleDateFormat.parse(taskInfo.get("taskDate"));
                task.setTaskDate(date);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(taskMapper.insert(task)>0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }


    }

    @Override
    public String choiceLastPrimaryKey() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String current = formatter.format(date)+'%';
        return taskMapper.selectLastPrimaryKey(current);
    }

    @Override
    public Boolean changeByPrimaryKey(Task task) {
        task.setTaskState("已评价");
        if(taskMapper.updateByPrimaryKey(task)>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public Boolean changeState(Task task){
        if(taskMapper.updateState(task)>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<Task> choiceAll() {
        return taskMapper.selectAll();
    }

    @Override
    public List<Task> selectByName(String name){
        return taskMapper.selectByName(name);
    }
}
