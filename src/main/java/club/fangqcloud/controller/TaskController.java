package club.fangqcloud.controller;

import club.fangqcloud.pojo.Task;
import club.fangqcloud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @RequestMapping("/getTaskList.do")
    @ResponseBody
    public List<Map> getTaskList(String state){
        return taskService.choiceList(state);
    }
    
    @RequestMapping("/getTaskListByOpenid.do")
    @ResponseBody
    public List<Map> getTaskListByOpenid(String openid){
        return taskService.choiceListByOpenid(openid);
    }
    
    @RequestMapping("/addTask.do")
    @ResponseBody
    public Boolean addTask(@RequestParam Map<String,String> taskInfo){
        return taskService.create(taskInfo);
    }
    
    @RequestMapping("/changeTaskState.do")
    @ResponseBody
    public Boolean changeTaskState(Task task){
        return taskService.changeState(task);
    }
    
    @RequestMapping("/alterTask.do")
    @ResponseBody
    public Boolean alterTask(Task task){
        return taskService.changeByPrimaryKey(task);
    }

    @RequestMapping("/getAll.do")
    @ResponseBody
    public List<Task> getAll(){
        return taskService.choiceAll();
    }

    @RequestMapping("/getByName.do")
    @ResponseBody
    public List<Task> getByName(String name){
        return taskService.selectByName(name);
    }
}
