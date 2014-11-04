package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 央行动态
 * @author 杨敏
 *
 */
public class Yhdt implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Yhdt(){ }
	private int id;
	private String bank;
	private String lastMeet;
	private String nowlv;
	private String nextMeet;
	/**
	 * 预期
	 */
	private String expect;
	private String externaldate; //采集时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getLastMeet() {
		return lastMeet;
	}
	public void setLastMeet(String lastMeet) {
		this.lastMeet = lastMeet;
	}
	public String getNowlv() {
		return nowlv;
	}
	public void setNowlv(String nowlv) {
		this.nowlv = nowlv;
	}
	public String getNextMeet() {
		return nextMeet;
	}
	public void setNextMeet(String nextMeet) {
		this.nextMeet = nextMeet;
	}
	public String getExpect() {
		return expect;
	}
	public void setExpect(String expect) {
		this.expect = expect;
	}
	public String getExternaldate() {
		return externaldate;
	}
	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}

}
