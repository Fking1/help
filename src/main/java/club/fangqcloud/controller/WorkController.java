package club.fangqcloud.controller;

import club.fangqcloud.pojo.Worker;
import club.fangqcloud.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping("/getAll.do")
    @ResponseBody
    public List<Worker> getAll(){
        return workerService.selectAll();
    }
}
