package club.fangqcloud.controller;

import club.fangqcloud.pojo.Task;
import club.fangqcloud.service.TaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @RequestMapping("/getList.do")
    @ResponseBody
    public List<Map> getList(String taskState){
        return taskService.choiceList(taskState);
    }
    
    @RequestMapping("/getTaskListByOpenid.do")
    @ResponseBody
    public List<Map> getTaskListByOpenid(String openid){
        return taskService.choiceListByOpenid(openid);
    }
    
    @RequestMapping("/add.do")
    @ResponseBody
    public Boolean add(@RequestParam Map<String,String> taskInfo){
        return taskService.add(taskInfo);
    }

    @RequestMapping("/insert.do")
    @ResponseBody
    public Boolean insert(Task task){
        return taskService.insert(task);
    }
    
    @RequestMapping("/changeTaskState.do")
    @ResponseBody
    public Boolean changeTaskState(Task task){
        return taskService.changeState(task);
    }
    
    @RequestMapping("/modify.do")
    @ResponseBody
    public Boolean modify(Task taskInfo){
        return taskService.changeByPrimaryKey(taskInfo);
    }

    @RequestMapping("/getAll.do")
    @ResponseBody
    public PageInfo<Task> getAll(@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "5") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Task> pageInfo = new PageInfo<>(taskService.choiceAll());
        return pageInfo;
    }

    @RequestMapping("/getByTaskId.do")
    @ResponseBody
    public PageInfo<Task> getByTaskId(@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "3") int pageSize,String taskId){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Task> pageInfo = new PageInfo<>(taskService.selectByTaskId(taskId));
        return pageInfo;
    }


    @RequestMapping(value = "/remove.do",method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean remove(String taskId){
        return taskService.delete(taskId);
    }
}
