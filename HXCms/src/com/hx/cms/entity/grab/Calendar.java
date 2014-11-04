package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 财经日历
 * @author 杨敏
 *
 */
public class Calendar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String cid;
	private String date;
	private String time;
	private String currency;
	private String country;
	private String event;
	private String description;
	private String period;
	private String importance;
	private String previous;
	private String median;
	private String ifr_actual;
	private String externaldate; //采集时间
	
	public Calendar(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public String getMedian() {
		return median;
	}
	public void setMedian(String median) {
		this.median = median;
	}
	public String getIfr_actual() {
		return ifr_actual;
	}
	public void setIfr_actual(String ifr_actual) {
		this.ifr_actual = ifr_actual;
	}

	public String getExternaldate() {
		return externaldate;
	}

	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}
 
}
