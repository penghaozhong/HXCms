package com.hx.cms.dao.main.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.hx.cms.dao.main.FullCalendarDao;
import com.hx.cms.entity.main.FullCalendar;
import com.hx.common.hibernate3.Finder;
import com.hx.common.hibernate3.HibernateBaseDao;
import com.hx.common.page.Pagination;

@Repository
public class FullCalendarDaoImpl extends HibernateBaseDao<FullCalendar, Integer> implements FullCalendarDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public List getCalendarList(Integer userId,String start){
		Finder f = Finder.create("from FullCalendar bean where (bean.userId = :userId or bean.userId=0) ");		
		if(start!=null){
			f.append(" and bean.start like :start order by bean.start");
			f.setParam("start", start+"%");
			
		}else{
			f.append("order by bean.start");
		}
		f.setParam("userId", userId);
		return find(f);
	}
	public FullCalendar findById(Integer id) {
		FullCalendar entity = get(id);
		return entity;
	}

	public FullCalendar save(FullCalendar bean) {
		getSession().save(bean);
		return bean;
	}

	public FullCalendar deleteById(Integer id) {
		FullCalendar entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<FullCalendar> getEntityClass() {
		return FullCalendar.class;
	}
}