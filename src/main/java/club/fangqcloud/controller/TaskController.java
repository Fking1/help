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
    
//    @RequestMapping("/getTaskList.do")
//    @ResponseBody
//    public List<Map> getTaskList(){
//        return taskService.choiceList();
//    }
    
    @RequestMapping("/getTaskListByOpenid.do")
    @ResponseBody
    public List<Map> getTaskListByOpenid(String openid){
        return taskService.choiceListByOpenid(openid);
    }
    
//    @RequestMapping("/addTask.do")
//    @ResponseBody
//    public Boolean addTask(@RequestParam Map<String,String> taskInfo){
//        return taskService.create(taskInfo);
//    }
    
//    @RequestMapping("/alterTask.do")
//    @ResponseBody
//    public Boolean alterTask(Task task){
//        return taskService.changeByPrimaryKey(task);
//    }
}
