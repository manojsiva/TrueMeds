package com.src.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "input_details")
public class Input {

	
	@Id
	private Integer id;
	private String input_string;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInput_string() {
		return input_string;
	}
	public void setInput_string(String input_string) {
		this.input_string = input_string;
	}
	
	
}
