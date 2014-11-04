package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 招商银行
 * @author 杨敏
 *
 */
public class CmbBank implements Serializable{

	private int id;
	private String currencyName;
	private String company;
	private String basicbi;
	private String convertPrice;
	private String nowCSellPrice;
	private String nowHBuyPrice;
	private String nowCBuyPrice;
	private String externaldate;//采集时间
	
	public CmbBank() {
		super();
 	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBasicbi() {
		return basicbi;
	}
	public void setBasicbi(String basicbi) {
		this.basicbi = basicbi;
	}
	public String getConvertPrice() {
		return convertPrice;
	}
	public void setConvertPrice(String convertPrice) {
		this.convertPrice = convertPrice;
	}
	public String getNowCSellPrice() {
		return nowCSellPrice;
	}
	public void setNowCSellPrice(String nowCSellPrice) {
		this.nowCSellPrice = nowCSellPrice;
	}
	public String getNowHBuyPrice() {
		return nowHBuyPrice;
	}
	public void setNowHBuyPrice(String nowHBuyPrice) {
		this.nowHBuyPrice = nowHBuyPrice;
	}
	public String getNowCBuyPrice() {
		return nowCBuyPrice;
	}
	public void setNowCBuyPrice(String nowCBuyPrice) {
		this.nowCBuyPrice = nowCBuyPrice;
	}
	public String getExternaldate() {
		return externaldate;
	}
	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}
 
}
