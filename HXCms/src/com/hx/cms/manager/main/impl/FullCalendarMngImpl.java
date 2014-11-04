package com.hx.cms.manager.main.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hx.cms.dao.main.FullCalendarDao;
import com.hx.cms.entity.main.FullCalendar;
import com.hx.cms.manager.main.FullCalendarMng;
import com.hx.common.hibernate3.Updater;
import com.hx.common.page.Pagination;

@Service
@Transactional
public class FullCalendarMngImpl implements FullCalendarMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List getList(Integer userId,String start) {
		List list = dao.getCalendarList(userId,start);
		return list;
	}
	
	@Transactional(readOnly = true)
	public FullCalendar findById(Integer id) {
		FullCalendar entity = dao.findById(id);
		return entity;
	}

	public FullCalendar save(FullCalendar bean) {
		dao.save(bean);
		return bean;
	}

	public FullCalendar update(FullCalendar bean) {
		Updater<FullCalendar> updater = new Updater<FullCalendar>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public FullCalendar deleteById(Integer id) {
		FullCalendar bean = dao.deleteById(id);
		return bean;
	}
	
	public FullCalendar[] deleteByIds(Integer[] ids) {
		FullCalendar[] beans = new FullCalendar[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FullCalendarDao dao;

	@Autowired
	public void setDao(FullCalendarDao dao) {
		this.dao = dao;
	}
}