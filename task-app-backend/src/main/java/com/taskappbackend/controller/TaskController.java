package com.taskappbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskappbackend.model.Task;
import com.taskappbackend.repository.TaskRepository;

@RestController
public class TaskController {
	@Autowired
	private TaskRepository taskRepo;
	
	@GetMapping("/tasks")
	public ResponseEntity<?> getAllTask(){
		List<Task> tasks = taskRepo.findAll();
		return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<?> createTask(@RequestBody Task task){
		try {

			task.setCompleted(false);
			taskRepo.save(task);
			//return new ResponseEntity<Task>(task,HttpStatus.OK);
			
			/*-------*/
			List<Task> tasks = taskRepo.findAll();
			return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);//
			/*-------*/
		}catch(Exception e){
			/*-------*/
			List<Task> tasks = taskRepo.findAll();
			return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);//
			/*-------*/
			//return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<?> getSingleTask(@PathVariable("id") String id){
		Optional <Task> taskOptional = taskRepo.findById(id);
		if(taskOptional.isPresent()) {
			return new ResponseEntity<>(taskOptional.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<?> UpddateById(@PathVariable("id") String id){
		Optional <Task> taskOptional = taskRepo.findById(id);
		if(taskOptional.isPresent()) {
			Task taskToSave = taskOptional.get();
			taskToSave.setCompleted(true);
			taskRepo.save(taskToSave);
			/*-------*/
			List<Task> tasks = taskRepo.findAll();
			return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);//
			/*-------*/
			//return new ResponseEntity<>(taskOptional.get(),HttpStatus.OK);
		}else {
			/*-------*/
			List<Task> tasks = taskRepo.findAll();
			return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);//
			/*-------*/
			//return new ResponseEntity<>("Not",HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id){
		try {
			taskRepo.deleteById(id);
			/*-------*/
			List<Task> tasks = taskRepo.findAll();
			return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);//
			/*-------*/
			//return new ResponseEntity<>("Success",HttpStatus.OK);
		}catch(Exception e) {
			/*-------*/
			List<Task> tasks = taskRepo.findAll();
			return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);//
			/*-------*/
			// return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	

