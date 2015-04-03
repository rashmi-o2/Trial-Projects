package com.tw.service.parser;

import java.util.ArrayList;
import java.util.List;

import com.tw.model.Talk;
import com.tw.util.Constants;

public class InputParserImpl implements InputParser {

	@Override
	public List<Talk> parseInput(List<String> inputList) {
		List<Talk> talkList = new ArrayList<Talk>();
		for (String input : inputList) {
			talkList.add(processInput(input));
		}
		return talkList;
	}

	private Talk processInput(String input) {
		String tokens[] = input.split(Constants.SPLIT_PATTERN);
		Integer time = getTalkLength(tokens[tokens.length-1].replaceAll(Constants.REPLACE_PATTERN, "$2"));
		return new Talk(input, time);
	}

	private Integer getTalkLength(String time) {
		Integer length = 5;
		try {
			length = Integer.parseInt(time);
		}
		catch(NumberFormatException exception) {
			
		}
		return length;
	}
}
