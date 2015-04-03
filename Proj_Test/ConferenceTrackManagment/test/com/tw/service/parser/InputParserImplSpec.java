package com.tw.service.parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tw.builder.TalkBuilder;
import com.tw.model.Talk;

public class InputParserImplSpec {
	
	private List<String> inputTalks;
	private InputParserImpl inputParserImpl;
	
	@Before
	public void setup() {
		inputTalks = new ArrayList<String>();
		inputTalks.add("Writing Fast Tests Against Enterprise Rails 60min");
		inputTalks.add("Overdoing it in Python 45min");
		inputParserImpl = new InputParserImpl();
	}

	@Test
	public void itShouldReturnParsedTalk() {
		List<Talk> expectedTalks = new ArrayList<Talk>();
		TalkBuilder talkBuilder = new TalkBuilder();
		expectedTalks.add(talkBuilder.withTitle("Writing Fast Tests Against Enterprise Rails 60min")
							.withLength(60).build());
		expectedTalks.add(talkBuilder.withTitle("Overdoing it in Python lightning")
							.withLength(5).build());
		
		List<Talk> actualTalks = inputParserImpl.parseInput(inputTalks);

		assert expectedTalks.size() == actualTalks.size();
		for (Talk expectedTalk : expectedTalks) {
			boolean isFound = false;
			for (Talk actualTalk : actualTalks) {
				if(expectedTalk.equals(actualTalk)) {
					isFound = true;
				}
			}
			assert isFound;
		}
	}

}
