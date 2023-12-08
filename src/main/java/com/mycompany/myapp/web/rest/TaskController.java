package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Task;
import com.mycompany.myapp.service.TaskService;
import com.mycompany.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/TMS/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("{title}")
    public Task getTask(@ModelAttribute("title") String title) {
        Task task = taskService.getTaskByTitle(title);
        System.out.println(task.getId());
        return task;
    }
    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        System.out.println(task.getId() + " " + task.getAssignee().getId() + " " + task.getCreator().getId());
        return taskService.addTask(task);
    }
    @PatchMapping("/update")
    public Task updateTask(@RequestBody Task task) {
        Task currTask = taskService.getTaskByTitle(task.getTitle());
        System.out.println("aaaa" +  task.getTitle());
        if(currTask == null) {
            return null;
        }
        currTask.setAssignee(task.getAssignee());
        currTask.setCreator(task.getCreator());
        currTask.setDescription(task.getDescription());
        currTask.setPriority(task.getPriority());
        currTask.setStatus(task.getStatus());
        taskService.addTask(currTask);
        return currTask;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@ModelAttribute("id") Long id) {
        taskService.deleteTask(id);
        return "Success";
    }
}
