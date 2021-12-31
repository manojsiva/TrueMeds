package com.src.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "manoj_sivaprakasam_java_output")
public class Output {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonInclude(value = Include.NON_NULL)
	private Integer id;
	private Date timestamp;
	private String input;
	private String output;
	private Integer steps_count;

	public Output() {
	}

	public Output(Date timestamp, String input, String output, Integer steps_count) {
		super();
		this.timestamp = timestamp;
		this.input = input;
		this.output = output;
		this.steps_count = steps_count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public Integer getSteps_count() {
		return steps_count;
	}

	public void setSteps_count(Integer steps_count) {
		this.steps_count = steps_count;
	}

}
