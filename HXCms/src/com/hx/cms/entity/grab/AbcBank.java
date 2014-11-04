package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 农业银行
 * @author 杨敏
 *
 */
public class AbcBank implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String currencyName;
	private String exchange; //基准汇率
	private String nowHBuyPrice;
	private String nowSellPrice;
	private String nowCBuyPrice;
	private String externaldate;//采集时间
	
	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getNowSellPrice() {
		return nowSellPrice;
	}
	public void setNowSellPrice(String nowSellPrice) {
		this.nowSellPrice = nowSellPrice;
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

	public AbcBank() {
		super();
	}
	
}
