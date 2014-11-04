package com.hx.cms.entity.grab;

import java.io.Serializable;

/**
 * 上海期货交易所实体类
 * @author Administrator
 *
 */
public class Shfuture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String latestpri;
	private String change;
	private String buypri;
	private String buyvol;
	private String sellpri;
	private String sellvol;
	private String tradvol;
	private String open;
	private String lastclear;
	private String maxpri;
	private String minpri;
	private String position;
	private String zengcang;
	private String time;
	private String externaldate;//采集时间 
 
	public String getExternaldate() {
		return externaldate;
	}
	public void setExternaldate(String externaldate) {
		this.externaldate = externaldate;
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
	public String getLatestpri() {
		return latestpri;
	}
	public void setLatestpri(String latestpri) {
		this.latestpri = latestpri;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public String getBuypri() {
		return buypri;
	}
	public void setBuypri(String buypri) {
		this.buypri = buypri;
	}
	public String getBuyvol() {
		return buyvol;
	}
	public void setBuyvol(String buyvol) {
		this.buyvol = buyvol;
	}
	public String getSellpri() {
		return sellpri;
	}
	public void setSellpri(String sellpri) {
		this.sellpri = sellpri;
	}
	public String getSellvol() {
		return sellvol;
	}
	public void setSellvol(String sellvol) {
		this.sellvol = sellvol;
	}
	public String getTradvol() {
		return tradvol;
	}
	public void setTradvol(String tradvol) {
		this.tradvol = tradvol;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getLastclear() {
		return lastclear;
	}
	public void setLastclear(String lastclear) {
		this.lastclear = lastclear;
	}
	public String getMaxpri() {
		return maxpri;
	}
	public void setMaxpri(String maxpri) {
		this.maxpri = maxpri;
	}
	public String getMinpri() {
		return minpri;
	}
	public void setMinpri(String minpri) {
		this.minpri = minpri;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getZengcang() {
		return zengcang;
	}
	public void setZengcang(String zengcang) {
		this.zengcang = zengcang;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
