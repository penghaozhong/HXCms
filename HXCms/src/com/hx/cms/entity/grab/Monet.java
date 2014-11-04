package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 货币型基金实体类
 * 
 * @author 杨敏
 * 
 */
public class Monet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String code;
	private String name;
	private String dayreturn;
	private String sevenratereturn;
	private String yearincome;
	private String annualyield;
	private String time;
	private String externaldate;// 采集时间
	
	public Monet(){}
	
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
	public String getDayreturn() {
		return dayreturn;
	}

	public void setDayreturn(String dayreturn) {
		this.dayreturn = dayreturn;
	}

	public String getSevenratereturn() {
		return sevenratereturn;
	}

	public void setSevenratereturn(String sevenratereturn) {
		this.sevenratereturn = sevenratereturn;
	}

	public String getYearincome() {
		return yearincome;
	}

	public void setYearincome(String yearincome) {
		this.yearincome = yearincome;
	}

	public String getAnnualyield() {
		return annualyield;
	}

	public void setAnnualyield(String annualyield) {
		this.annualyield = annualyield;
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
