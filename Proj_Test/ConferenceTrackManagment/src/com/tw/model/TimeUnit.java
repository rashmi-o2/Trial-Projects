package com.tw.model;

public class TimeUnit {
	private Integer hours;
	private Integer minutes;
	private Meridiem meridiem;
	
	public TimeUnit(Integer hours, Integer minutes, Meridiem meridiem) {
		this.hours    = hours;
		this.minutes  = minutes;
		this.meridiem = meridiem;
	}
	
	@Override
	public String toString() {
		String hourString = hours < 10 ? "0"+hours : hours.toString();
		String minString  = minutes < 10 ? "0"+minutes : minutes.toString();
		return hourString + ":" + minString + meridiem;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public Meridiem getMeridiem() {
		return meridiem;
	}

	public void setMeridiem(Meridiem meridiem) {
		this.meridiem = meridiem;
	}
	
	public Integer getTimeInMinutes() {
		if(Meridiem.AM.equals(meridiem)) {
			return hours * 60 + minutes;
		}
		else {
			// calculation for PM Meridiem
			return 12 * 60 + hours * 60 + minutes;
		}
	}

	public void addMinutes(Integer timeInMinutes) {
		int totalMinutes = 0;

		if(Meridiem.AM.equals(meridiem)) {
			totalMinutes = hours * 60 + minutes + timeInMinutes;
		}
		else {
			// calculation for PM Meridiem
			totalMinutes = 12 * 60 + hours * 60 + minutes + timeInMinutes;
		}
		
		if(totalMinutes < 12 * 60) {
			meridiem = Meridiem.AM;
		}
		else {
			totalMinutes -= 12 * 60;
			meridiem = Meridiem.PM;
		}
		
		hours	 = totalMinutes / 60;
		minutes  = totalMinutes % 60;
	}
}
