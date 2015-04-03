package com.tw.repository;

import java.util.List;

import com.tw.model.Talk;
import com.tw.model.Track;
import com.tw.processor.TrackProcessor;
import com.tw.processor.TrackProcessorImpl;
import com.tw.util.Constants;

public class TrackRepository {
	
	private TrackProcessor trackProcessor;
	
	public TrackRepository() {
		this.trackProcessor = new TrackProcessorImpl();
	}
	
	public TrackRepository(TrackProcessor trackProcessor) {
		this.trackProcessor = trackProcessor;
	}
	
	public List<Track> getTracks(List<Talk> talks) {
		int noOfTracks = calculateNoOfTracks(talks);
		return trackProcessor.organizeTalksInSession(noOfTracks, talks);
	}
	
	private int calculateNoOfTracks(List<Talk> talks) {
		int totalTimeStamp = 0;
		for (Talk talk : talks) {
			totalTimeStamp += talk.getLength();
		}
		
		int track = totalTimeStamp / Constants.TRACK_TIME_LENGTH;
		if(totalTimeStamp % Constants.TRACK_TIME_LENGTH > 0) {
			track++;
		}
		return track;
	}
}
