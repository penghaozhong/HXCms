package com.hx.cms.dao.main.impl;

import org.springframework.stereotype.Repository;

import com.hx.cms.dao.main.CmsUserResumeDao;
import com.hx.cms.entity.main.CmsUserResume;
import com.hx.common.hibernate3.HibernateBaseDao;

@Repository
public class CmsUserResumeDaoImpl extends HibernateBaseDao<CmsUserResume, Integer> implements CmsUserResumeDao {
	public CmsUserResume findById(Integer id) {
		CmsUserResume entity = get(id);
		return entity;
	}

	public CmsUserResume save(CmsUserResume bean) {
		getSession().save(bean);
		return bean;
	}
	
	@Override
	protected Class<CmsUserResume> getEntityClass() {
		return CmsUserResume.class;
	}
}