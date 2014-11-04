package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 期货行情
 * @author 杨敏
 *
 */
public class EmbPrice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String newPrice ;
	private String highsALows ;
	private String bugPrice ;
	private String bugNum ;
	private String sellPrice ;
	private String sellNul ;
	private String volume ;
	private String todayPrice ;
	private String yesterDayPrice  ;
	private String maxPrice  ;
	private String minPrice  ;
	private String stock  ;
	private String addStock ;
	private String externaldate; //采集时间
	
	public EmbPrice(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(String newPrice) {
		this.newPrice = newPrice;
	}

	public String getHighsALows() {
		return highsALows;
	}

	public void setHighsALows(String highsALows) {
		this.highsALows = highsALows;
	}

	public String getBugPrice() {
		return bugPrice;
	}

	public void setBugPrice(String bugPrice) {
		this.bugPrice = bugPrice;
	}

	public String getBugNum() {
		return bugNum;
	}

	public void setBugNum(String bugNum) {
		this.bugNum = bugNum;
	}

	public String getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getSellNul() {
		return sellNul;
	}

	public void setSellNul(String sellNul) {
		this.sellNul = sellNul;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getTodayPrice() {
		return todayPrice;
	}

	public void setTodayPrice(String todayPrice) {
		this.todayPrice = todayPrice;
	}

	public String getYesterDayPrice() {
		return yesterDayPrice;
	}

	public void setYesterDayPrice(String yesterDayPrice) {
		this.yesterDayPrice = yesterDayPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getAddStock() {
		return addStock;
	}

	public void setAddStock(String addStock) {
		this.addStock = addStock;
	}

	public String getExternaldate() {
		return externaldate;
	}

	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}
	

}
