package com.hx.cms.manager.main;

import java.util.List;

import com.hx.cms.entity.main.FullCalendar;
import com.hx.common.page.Pagination;

public interface FullCalendarMng {
	public Pagination getPage(int pageNo, int pageSize);

	public FullCalendar findById(Integer id);

	public FullCalendar save(FullCalendar bean);

	public FullCalendar update(FullCalendar bean);

	public FullCalendar deleteById(Integer id);
	
	public FullCalendar[] deleteByIds(Integer[] ids);
	
	public List getList(Integer userId,String start);
}