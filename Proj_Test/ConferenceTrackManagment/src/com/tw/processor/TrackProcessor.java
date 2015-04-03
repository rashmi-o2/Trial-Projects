package com.tw.processor;

import java.util.List;

import com.tw.model.Talk;
import com.tw.model.Track;

public interface TrackProcessor {
	
	public List<Track> organizeTalksInSession(int noOfTracks, List<Talk> talks);
}
