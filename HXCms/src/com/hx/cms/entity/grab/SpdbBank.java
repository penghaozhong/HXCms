package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 浦发银行
 * @author 杨敏
 *
 */
public class SpdbBank implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String currency;
	private String mid; //基准汇率
	private String bidfx ;
	private String bidcash;
	private String offer;
	private String externaldate;//采集时间
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getBidfx() {
		return bidfx;
	}

	public void setBidfx(String bidfx) {
		this.bidfx = bidfx;
	}

	public String getBidcash() {
		return bidcash;
	}

	public void setBidcash(String bidcash) {
		this.bidcash = bidcash;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getExternaldate() {
		return externaldate;
	}

	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}

	public SpdbBank() {
		super();
	}
	
}
