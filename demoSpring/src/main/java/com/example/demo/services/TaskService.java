package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entityexamples.Tasks;
import com.example.demo.repos.TaskDao;

@Service
public class TaskService {

	@Autowired
	TaskDao ts;
	public Tasks saveTask(Tasks task) {
		return ts.save(task);
	}

}
