package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entityexamples.Tasks;
import com.example.demo.repos.TaskDao;
import com.example.demo.services.TaskService;


@RestController
public class TaskController {
	@Autowired
	TaskService taskService;
	@Autowired
	TaskDao taskDao;
	
	
	@PostMapping("/taskupdate")
	public Tasks saveTasks(@RequestBody Tasks task)
	{
		return taskService.saveTask(task);
	}
	@GetMapping("/tasks")
	public List<Tasks> getAllTasks()
	{
		return taskDao.findAll();
	}
	@GetMapping("tasks/{id}")
	public Optional<Tasks> getTaskById(@PathVariable long id)
	{
		return taskDao.findById(id);
	}

}
