package com.tw.processor;

import java.util.ArrayList;
import java.util.List;

import com.tw.model.Session;
import com.tw.model.Talk;
import com.tw.model.Track;
import com.tw.util.Constants;

public class TrackProcessorImpl implements TrackProcessor {
	
	@Override
	public List<Track> organizeTalksInSession(int noOfTracks, List<Talk> talks) {
		List<Track> tracks = new ArrayList<Track>();
		for(Integer itr=0; itr < noOfTracks; itr++) {
			Session morningSession = new Session(fetchTalksForSession(talks, Constants.MORNING_SESSION_TIME_LENGTH)
											, Constants.MORNING_SESSION_START_TIME);
			Session eveningSession = new Session(fetchTalksForSession(talks, Constants.EVENING_SESSION_TIME_LENGTH)
											, Constants.EVENING_SESSION_START_TIME);
			tracks.add(new Track(morningSession, eveningSession));
		}
		return tracks;
	}
	
	private Integer getTotalLengthOfTalks(List<Talk> talks) {
		Integer timeLength = 0;
		for (Talk talk : talks) {
			timeLength += talk.getLength();
		}
		return timeLength;
	}
	
	private List<Talk> fetchTalksForSession(List<Talk> talks, Integer sessionLength) {
		List<Talk> selectedTalks = new ArrayList<Talk>();
		for (Talk talk : talks) {
			if(getTotalLengthOfTalks(selectedTalks) + talk.getLength() < sessionLength) {
				selectedTalks.add(talk);
			}
		}
		talks.removeAll(selectedTalks);
		return selectedTalks;
	}
}
