package com.src.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.src.model.Output;
import com.src.service.TrueMedsService;

@RestController
public class Controller {

	private static final Logger LOGGER = LogManager.getLogger(Controller.class);

	@Autowired
	TrueMedsService service;

	@GetMapping("/processedInput")
	public ResponseEntity<?> getDBOutput() {
		try {
			List<Output> outputList = service.processInputFromDB();
			return ResponseEntity.ok(outputList);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("Exception Occured: {}", e.getMessage(), e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/process-string/{input}")
	public ResponseEntity<Output> getOutputbyInput(@PathVariable String input) {
		Output output = service.modifyInputString(input);
		return ResponseEntity.ok(output);
	}
}
