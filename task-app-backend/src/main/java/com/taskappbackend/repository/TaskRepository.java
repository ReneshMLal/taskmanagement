package com.taskappbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.taskappbackend.model.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

}
