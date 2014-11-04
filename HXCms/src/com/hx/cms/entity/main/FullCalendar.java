package com.hx.cms.entity.main;

import java.util.Date;

public class FullCalendar {
	private Integer id;
	private String title;
	private String start;
	private String end;
	private String allDay;
	private String color;
	private com.hx.cms.entity.main.CmsSite site;
	private Integer userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getAllDay() {
		return allDay;
	}
	public void setAllDay(String allDay) {
		this.allDay = allDay;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public com.hx.cms.entity.main.CmsSite getSite() {
		return site;
	}
	public void setSite(com.hx.cms.entity.main.CmsSite site) {
		this.site = site;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

}
