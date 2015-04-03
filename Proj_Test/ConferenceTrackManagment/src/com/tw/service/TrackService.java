package com.tw.service;

import java.util.List;

import com.tw.model.Talk;
import com.tw.model.Track;
import com.tw.repository.TrackRepository;
import com.tw.service.parser.InputParser;
import com.tw.service.parser.InputParserImpl;

public class TrackService {
	
	TrackRepository trackRepository;
	InputParser inputParser;
	
	public TrackService() {
		trackRepository = new TrackRepository();
		inputParser = new InputParserImpl();
	}
	
	public TrackService(TrackRepository trackRepository, InputParser inputParser) {
		this.inputParser = inputParser;
		this.trackRepository = trackRepository;
	}

	public List<Track> scheduleTracks(List<String> inputList) {
		List<Talk> talks = inputParser.parseInput(inputList);
		return trackRepository.getTracks(talks);
	}

}
