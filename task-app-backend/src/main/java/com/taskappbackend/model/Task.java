package com.taskappbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="tasks")
public class Task {
	@Id
	private String id;
	
	private String task;
	
	private Boolean completed;
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public void setCompleted(boolean b) {
		this.completed=b;
		
	}
	public String getTask() {
		return task;
	}
	public Boolean getcompleted() {
		return completed;
	}
}
