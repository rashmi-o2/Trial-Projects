package com.tw.builder;

import com.tw.model.Talk;

public class TalkBuilder {
	private String title;
	private Integer length;
	
	public TalkBuilder() {
		
	}
	
	public TalkBuilder withTitle(String title) {
		this.title = title;
		return this;
	}
	
	public TalkBuilder withLength(Integer length) {
		this.length = length;
		return this;
	}
	
	public Talk build() {
		return new Talk(title, length);
	}
	
}
