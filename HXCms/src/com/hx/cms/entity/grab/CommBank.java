package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 交通银行
 * @author 杨敏
 *
 */
public class CommBank implements Serializable{

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String currency;
	private String per;
	private String exchBid;
	private String exchOffer;
	private String cashBid;
	private String cashOffer;
	private String timeUpate;
	private String externaldate;//采集时间
	
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	public String getExchBid() {
		return exchBid;
	}
	public void setExchBid(String exchBid) {
		this.exchBid = exchBid;
	}
	public String getExchOffer() {
		return exchOffer;
	}
	public void setExchOffer(String exchOffer) {
		this.exchOffer = exchOffer;
	}
	public String getCashBid() {
		return cashBid;
	}
	public void setCashBid(String cashBid) {
		this.cashBid = cashBid;
	}
	public String getCashOffer() {
		return cashOffer;
	}
	public void setCashOffer(String cashOffer) {
		this.cashOffer = cashOffer;
	}
	public String getTimeUpate() {
		return timeUpate;
	}
	public void setTimeUpate(String timeUpate) {
		this.timeUpate = timeUpate;
	}
	public CommBank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	public String getExternaldate() {
		return externaldate;
	}
	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}
	 
}
