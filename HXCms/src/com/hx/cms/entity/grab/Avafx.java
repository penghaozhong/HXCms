package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 原油金属期货 -->avafx实体类
 * 
 * @author 杨敏
 * 
 */
public class Avafx implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	private int id;
	private String datetimes;
	private String brand; // 品牌
	private String products;// 产品
	private String price;// 价格
	private String company; // 单位
	private String purity;// 纯度
	private String shougongfei; // 手工费
	private String zhangdie; // 涨跌
	private String externaldate; //采集时间
	
	public String getExternaldate() {
		return externaldate;
	}

	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatetimes() {
		return datetimes;
	}

	public void setDatetimes(String datetimes) {
		this.datetimes = datetimes;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPurity() {
		return purity;
	}

	public void setPurity(String purity) {
		this.purity = purity;
	}

	public String getShougongfei() {
		return shougongfei;
	}

	public void setShougongfei(String shougongfei) {
		this.shougongfei = shougongfei;
	}

	public String getZhangdie() {
		return zhangdie;
	}

	public void setZhangdie(String zhangdie) {
		this.zhangdie = zhangdie;
	}

	public Avafx() {
	}
}
