package com.tw.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tw.builder.TalkBuilder;
import com.tw.model.Talk;
import com.tw.model.Track;
import com.tw.processor.TrackProcessorImpl;

public class TrackProcessorImplSpec {

	private TrackProcessorImpl trackProcessorImpl;
	List<Talk> talks;
	
	@Before
	public void setup() {
		trackProcessorImpl = new TrackProcessorImpl();
		talks = new ArrayList<Talk>();
		TalkBuilder talkBuilder = new TalkBuilder();
		talks.add(talkBuilder.withTitle("Writing Fast Tests Against Enterprise Rails 60min")
							.withLength(60).build());
		talks.add(talkBuilder.withTitle("Ruby on Rails: Why We Should Move On 45min")
							.withLength(45).build());
		talks.add(talkBuilder.withTitle("Clojure Ate Scala (on my projects) 40min")
							.withLength(40).build());
		talks.add(talkBuilder.withTitle("Programming in the Boondocks of Seattle 30min")
							.withLength(30).build());
		talks.add(talkBuilder.withTitle("Overdoing it in Python 40min")
							.withLength(40).build());
		talks.add(talkBuilder.withTitle("Ruby on Rails: Why We Should Move On 45min")
							.withLength(45).build());
		talks.add(talkBuilder.withTitle("Ruby on Rails Legacy App Maintenance 60min")
							.withLength(60).build());
		talks.add(talkBuilder.withTitle("User Interface CSS in Rails Apps 30min")
							.withLength(30).build());
	}
	
	@Test
	public void itShouldReturnTrackForGivenTalks() {
		List<Track> tracks = trackProcessorImpl.organizeTalksInSession(1, talks);
		assert tracks.size() == 1;
		assert tracks.get(0).getMorningSession().getTalks().size() == 4;
		assert tracks.get(0).getEveningSession().getTalks().size() == 4;
	}

}
