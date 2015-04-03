package com.tw.service.parser;

import java.util.List;

import com.tw.model.Talk;

public interface InputParser {
	public List<Talk> parseInput(List<String> inputList);
}
