package com.tw.controller;

import java.util.List;

import com.tw.decorator.TrackAdapter;
import com.tw.model.Track;
import com.tw.service.TrackService;

public class TrackManagement {
	TrackService trackService;
	
	public TrackManagement() {
		this.trackService = new TrackService();
	}
	
	public TrackManagement(TrackService trackService) {
		this.trackService = trackService;
	}
	
	public List<Track> scheduleTalks(List<String> inputList) {
		return trackService.scheduleTracks(inputList);
	}
	
	public String schdeuleTalksAndDisplay(List<String> inputList, TrackAdapter trackAdapter) {
		List<Track> tracks = trackService.scheduleTracks(inputList);
		return trackAdapter.displayTracks(tracks);
	}
}
