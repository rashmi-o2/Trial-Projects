package com.tw.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tw.decorator.TrackAdapter;
import com.tw.decorator.TrackAdapterImpl;
import com.tw.model.Track;

public class TrackManagementSpec {

	private List<String> inputTalks;
	
	@Before
	public void setup() {
		inputTalks = new ArrayList<String>();
		inputTalks.add("Writing Fast Tests Against Enterprise Rails 60min");
		inputTalks.add("Overdoing it in Python 45min");
		inputTalks.add("Lua for the Masses 30min");
		inputTalks.add("Ruby Errors from Mismatched Gem Versions 45min");
		inputTalks.add("Common Ruby Errors 45min");
		inputTalks.add("Rails for Python Developers lightning");
		inputTalks.add("Communicating Over Distance 60min");
		inputTalks.add("Accounting-Driven Development 45min");
		inputTalks.add("Woah 30min");
		inputTalks.add("Sit Down and Write 30min");
		inputTalks.add("Pair Programming vs Noise 45min");
		inputTalks.add("Rails Magic 60min");
		inputTalks.add("Ruby on Rails: Why We Should Move On 60min");
		inputTalks.add("Clojure Ate Scala (on my projects) 45min");
		inputTalks.add("Programming in the Boondocks of Seattle 30min");
		inputTalks.add("Ruby vs. Clojure for Back-End Development 30min");
		inputTalks.add("Ruby on Rails Legacy App Maintenance 60min");
		inputTalks.add("A World Without HackerNews 30min");
		inputTalks.add("User Interface CSS in Rails Apps 30min");
	}
	
	@Test
	public void itShouldReturnTracks() {
		TrackManagement trackManagement = new TrackManagement();
		List<Track> tracks = trackManagement.scheduleTalks(inputTalks);
		assert tracks.size() == 2;
	}
	
	@Test
	public void itShouldScheduleAndDisplayTracks() {
		TrackManagement trackManagement = new TrackManagement();
		TrackAdapter trackAdapter = new TrackAdapterImpl();
		
		//Displaying output instead of assert
		System.out.println(trackManagement.schdeuleTalksAndDisplay(inputTalks, trackAdapter));
	}
}
