package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Task;
import com.mycompany.myapp.repository.TaskRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task getTaskByTitle(String title) {
        return taskRepository.getTaskByTitle(title);
    }
    public Task addTask(Task task) {
         return  taskRepository.save(task);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
