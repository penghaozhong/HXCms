package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 工行
 * @author 杨敏
 *
 */
public class IcbcBank implements Serializable {

	private int id;
	private String currencyName;
	private String nowHBuyPrice;
	private String nowCBuyPrice;
	private String nowSellPrice;
	private String releaseTime;
	private String externaldate;// 采集时间
	public IcbcBank(){}
	
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
	public String getNowSellPrice() {
		return nowSellPrice;
	}
	public void setNowSellPrice(String nowSellPrice) {
		this.nowSellPrice = nowSellPrice;
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
 
}
