package com.tw.decorator;

import java.util.List;

import com.tw.model.Meridiem;
import com.tw.model.Session;
import com.tw.model.Talk;
import com.tw.model.TimeUnit;
import com.tw.model.Track;
import com.tw.util.Constants;

public class TrackAdapterImpl implements TrackAdapter {

	@Override
	public String displayTracks(List<Track> tracks) {
		StringBuilder stringBuilder = new StringBuilder();
		Integer itr = 1;
		for (Track track : tracks) {
			stringBuilder.append("Track " + itr + ":\n");
			stringBuilder.append(displayTrack(track));
			stringBuilder.append("\n\n\n");
			itr++;
		}
		return stringBuilder.toString();
	}

	private String displayTrack(Track track) {
		return displayMorningSession(track.getMorningSession()) +
				displayLunchBreak() +
				displayEveningSession(track.getEveningSession());
	}
	
	private String displayLunchBreak() {
		return "12:00PM Lunch\n";
	}
	
	private String displayNetworkingTalk(String time) {
		return time + " Networking Event\n";
	}

	private String displayMorningSession(Session session) {
		TimeUnit timeUnit = constructTimeUnit(session.getSessionStartTime());
		StringBuilder builder = constructTalkDisplay(session, timeUnit);
		return builder.toString();
	}
	
	private String displayEveningSession(Session session) {
		TimeUnit timeUnit = constructTimeUnit(session.getSessionStartTime());
		StringBuilder builder = constructTalkDisplay(session, timeUnit);
		if(timeUnit.getTimeInMinutes() <= 16 * 60) {
			// If all talks complete by 4PM
			builder.append(displayNetworkingTalk("04:00PM"));
		}
		else {
			builder.append(displayNetworkingTalk("05:00PM"));
		}
		return builder.toString();
	}

	private StringBuilder constructTalkDisplay(Session session, TimeUnit timeUnit) {
		StringBuilder builder = new StringBuilder();
		for (Talk talk : session.getTalks()) {
			builder.append(timeUnit + " " + talk.getTitle() + "\n");
			timeUnit.addMinutes(talk.getLength());
		}
		return builder;
	}
	
	private TimeUnit constructTimeUnit(String time) {
		Integer hours = Integer.parseInt(time.replaceAll(Constants.TIME_PATTERN, "$2"));
		Integer minutes = Integer.parseInt(time.replaceAll(Constants.TIME_PATTERN, "$3"));
		Meridiem meridiem = time.replaceAll(Constants.TIME_PATTERN, "$4").equalsIgnoreCase("AM")? Meridiem.AM: Meridiem.PM;
		
		return new TimeUnit(hours, minutes, meridiem);
		
	}
}
