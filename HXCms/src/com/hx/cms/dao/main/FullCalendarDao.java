package com.hx.cms.dao.main;

import java.util.List;

import com.hx.cms.entity.main.FullCalendar;
import com.hx.common.hibernate3.Updater;
import com.hx.common.page.Pagination;

public interface FullCalendarDao {
	public Pagination getPage(int pageNo, int pageSize);

	public FullCalendar findById(Integer id);

	public FullCalendar save(FullCalendar bean);

	public FullCalendar updateByUpdater(Updater<FullCalendar> updater);

	public FullCalendar deleteById(Integer id);
	
	public List getCalendarList(Integer userId,String start);
}