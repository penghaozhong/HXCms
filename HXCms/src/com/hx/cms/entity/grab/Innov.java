package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 创新型基金实体类
 * 
 * @author 杨敏
 * 
 */
public class Innov implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String code;
	private String name;
	private String newnet;
	private String totalreturn;
	private String totalnet;
	private String weekgrowrate;
	private String monthgrowrate;
	private String time;
	private String externaldate;// 采集时间
	
	public Innov(){}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNewnet() {
		return newnet;
	}
	public void setNewnet(String newnet) {
		this.newnet = newnet;
	}
	public String getTotalnet() {
		return totalnet;
	}
	public void setTotalnet(String totalnet) {
		this.totalnet = totalnet;
	}
	 
	public String getWeekgrowrate() {
		return weekgrowrate;
	}
	public void setWeekgrowrate(String weekgrowrate) {
		this.weekgrowrate = weekgrowrate;
	}
	public String getMonthgrowrate() {
		return monthgrowrate;
	}
	public void setMonthgrowrate(String monthgrowrate) {
		this.monthgrowrate = monthgrowrate;
	}
	 
	public String getTotalreturn() {
		return totalreturn;
	}

	public void setTotalreturn(String totalreturn) {
		this.totalreturn = totalreturn;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getExternaldate() {
		return externaldate;
	}
	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}

}
