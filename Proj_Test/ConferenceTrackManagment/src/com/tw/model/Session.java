package com.tw.model;

import java.util.List;

public class Session {
	private List<Talk> talks;
	private String sessionStartTime;
	
	public Session(List<Talk> talks, String sessionString) {
		this.talks 	= talks;
		this.sessionStartTime = sessionString; 
	}
	
	public String getSessionStartTime() {
		 return sessionStartTime;
	}
	
	public List<Talk> getTalks() {
		return talks;
	}
	
	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}
	
	public void addTalk(Talk talk) {
		this.talks.add(talk);
	}
	
	public int getTotalLengthOfSession() {
		int length = 0;
		for (Talk talk : talks) {
			length += talk.getLength();
		}
		return length;
	}
}
