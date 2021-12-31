package com.src.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.model.Input;
import com.src.model.Output;
import com.src.repository.InputRepository;
import com.src.repository.OutputRepository;

@Service
public class TrueMedsService {

	@Autowired
	private InputRepository inputRepo;

	@Autowired
	private OutputRepository outputRepo;

	public List<Output> processInputFromDB() throws Exception {
		List<Input> inputList = inputRepo.findAll();
		List<Output> outputList = new ArrayList<>();

		if (inputList.isEmpty()) {
			throw new Exception("Input from DB is Empty");
		}
		for (Input each : inputList) {
			var output = modifyInputString(each.getInput_string());
			outputList.add(output);
		}

		outputRepo.saveAll(outputList);

		return outputList;
	}

	public Output modifyInputString(String inputString) {
		StringBuilder inputStringBuilder = new StringBuilder(inputString);
		int stepCount = 0;
		int iterCount = 0;

		do {
			iterCount = 0;
			for (int i = 0; i < inputStringBuilder.length() - 1; i++) {
				int j = i + 1;
				while (j < inputStringBuilder.length()) {
					if (inputStringBuilder.charAt(j) == ' ') {
						inputStringBuilder.deleteCharAt(j);
					}
					if (inputStringBuilder.charAt(i) == inputStringBuilder.charAt(j)) {
						j++;
					} else {
						break;
					}
				}
				if (j - i > 1) {
					inputStringBuilder.delete(i, j);
					iterCount++;
					i--;
				}
			}
			stepCount += iterCount;
		} while (iterCount > 0);
		Output output = new Output(new Date(), inputString, inputStringBuilder.toString(), stepCount);

		return output;
	}

}
