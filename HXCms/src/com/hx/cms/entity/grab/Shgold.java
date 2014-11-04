package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 上海黃金交易
 * @author Administrator
 *
 */
public class Shgold implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String variety;
	private String latestpri;
	private String openpri;
	private String maxpri;
	private String minpri;
	private String limit;
	private String yespri;
	private String totalvol;
	private String time;
	private String externaldate;//采集时间 
	
 

	public String getExternaldate() {
		return externaldate;
	}

	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}

	public Shgold(){}
	
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
	public String getLatestpri() {
		return latestpri;
	}
	public void setLatestpri(String latestpri) {
		this.latestpri = latestpri;
	}
	public String getOpenpri() {
		return openpri;
	}
	public void setOpenpri(String openpri) {
		this.openpri = openpri;
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
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getYespri() {
		return yespri;
	}
	public void setYespri(String yespri) {
		this.yespri = yespri;
	}
	public String getTotalvol() {
		return totalvol;
	}
	public void setTotalvol(String totalvol) {
		this.totalvol = totalvol;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
