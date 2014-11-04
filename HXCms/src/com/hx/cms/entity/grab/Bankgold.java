package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 银行账户黄金
 * @author Administrator
 *
 */
public class Bankgold implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String variety;
	private String midpri;
	private String buypri;
	private String sellpri;
	private String maxpri;
	private String minpri;
	private String todayopen;
	private String closeyes;
	private String quantpri;
	private String time;
	
	private String externaldate; //采集时间
	
	
 
	public String getExternaldate() {
		return externaldate;
	}
	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getMidpri() {
		return midpri;
	}
	public void setMidpri(String midpri) {
		this.midpri = midpri;
	}
	public String getBuypri() {
		return buypri;
	}
	public void setBuypri(String buypri) {
		this.buypri = buypri;
	}
	public String getSellpri() {
		return sellpri;
	}
	public void setSellpri(String sellpri) {
		this.sellpri = sellpri;
	}
	public String getMaxpri() {
		return maxpri;
	}
	public void setMaxpri(String maxpri) {
		this.maxpri = maxpri;
	}
	public String getMinpri() {
		return minpri;
	}
	public void setMinpri(String minpri) {
		this.minpri = minpri;
	}
	public String getTodayopen() {
		return todayopen;
	}
	public void setTodayopen(String todayopen) {
		this.todayopen = todayopen;
	}
	public String getCloseyes() {
		return closeyes;
	}
	public void setCloseyes(String closeyes) {
		this.closeyes = closeyes;
	}
	public String getQuantpri() {
		return quantpri;
	}
	public void setQuantpri(String quantpri) {
		this.quantpri = quantpri;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
