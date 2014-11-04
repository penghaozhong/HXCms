package com.hx.cms.entity.grab;

import java.io.Serializable;
import java.util.Date;

/**
 * 人民币牌价(内容页汇率)
 * @author Administrator
 *
 */
public class Rmbquot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String fBuyPri;
	private String mBuyPri;
	private String fSellPri;
	private String mSellPri;
	private String bankConversionPri;
	private String date;
	private String time;
	
	private String externaldate;//采集时间 
	 

	public String getExternaldate() {
		return externaldate;
	}

	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}

	public Rmbquot(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getfBuyPri() {
		return fBuyPri;
	}
	public void setfBuyPri(String fBuyPri) {
		this.fBuyPri = fBuyPri;
	}
	
	public String getMBuyPri() {
		return mBuyPri;
	}
	public void setMBuyPri(String mBuyPri) {
		this.mBuyPri = mBuyPri;
	}
	
	
	public String getfSellPri() {
		return fSellPri;
	}
	public void setfSellPri(String fSellPri) {
		this.fSellPri = fSellPri;
	}
	public String getMSellPri() {
		return mSellPri;
	}
	public void setMSellPri(String mSellPri) {
		this.mSellPri = mSellPri;
	}
	public String getBankConversionPri() {
		return bankConversionPri;
	}
	public void setBankConversionPri(String bankConversionPri) {
		this.bankConversionPri = bankConversionPri;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
 }
