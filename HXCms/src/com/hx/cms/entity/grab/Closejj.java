package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 封闭型基金实体类
 * 
 * @author 杨敏
 * 
 */
public class Closejj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String code;
	private String name;
	private String expdate;
	private String net;
	private String totalnet;
	private String weekgrowrate;
	private String closepri;
	private String price;
	private String premiumvalue;
	private String disrate;
	private String time;
	
	private String externaldate;// 采集时间
	
	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getNet() {
		return net;
	}

	public void setNet(String net) {
		this.net = net;
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

	public String getClosepri() {
		return closepri;
	}

	public void setClosepri(String closepri) {
		this.closepri = closepri;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPremiumvalue() {
		return premiumvalue;
	}

	public void setPremiumvalue(String premiumvalue) {
		this.premiumvalue = premiumvalue;
	}

	public String getDisrate() {
		return disrate;
	}

	public void setDisrate(String disrate) {
		this.disrate = disrate;
	}

	
	public Closejj(){}
	
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
