package com.tw.model;

public class Track {
	private Session morningSession;
	private Session eveningSession;
	
	public Track(Session morningSession, Session eveningSession) {
		this.morningSession = morningSession;
		this.eveningSession = eveningSession;
	}
		
	public Session getMorningSession() {
		return morningSession;
	}

	public void setMorningSession(Session morningSession) {
		this.morningSession = morningSession;
	}

	public Session getEveningSession() {
		return eveningSession;
	}

	public void setEveningSession(Session eveningSession) {
		this.eveningSession = eveningSession;
	}

	public int totalTimeLengthOfTalks() {
		int sumOfTimeLengths = 0;  
		for(Talk talk: morningSession.getTalks()) {
			sumOfTimeLengths += talk.getLength();
		}
		
		for(Talk talk: eveningSession.getTalks()) {
			sumOfTimeLengths += talk.getLength();
		}
		
		return sumOfTimeLengths;
	}
}
