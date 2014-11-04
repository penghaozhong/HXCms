package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 中国银行
 * @author 杨敏
 *
 */
public class BocBank implements Serializable {

	private int id;
	
	private String currencyName;
	private String nowHBuyPrice;
	private String nowCBuyPrice;
	private String nowHSellPrice;
	private String nowCSellPrice;
	private String convertPrice;
	private String releaseDate;
	private String releaseTime;
	private String externaldate;//采集时间
	
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




	public String getNowHSellPrice() {
		return nowHSellPrice;
	}




	public void setNowHSellPrice(String nowHSellPrice) {
		this.nowHSellPrice = nowHSellPrice;
	}




	public String getNowCSellPrice() {
		return nowCSellPrice;
	}




	public void setNowCSellPrice(String nowCSellPrice) {
		this.nowCSellPrice = nowCSellPrice;
	}




	public String getConvertPrice() {
		return convertPrice;
	}




	public void setConvertPrice(String convertPrice) {
		this.convertPrice = convertPrice;
	}




	public String getReleaseDate() {
		return releaseDate;
	}




	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}




	public String getReleaseTime() {
		return releaseTime;
	}




	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
 

	public String getExternaldate() {
		return externaldate;
	}




	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}




	public BocBank() {
		super();
	}
	
}
