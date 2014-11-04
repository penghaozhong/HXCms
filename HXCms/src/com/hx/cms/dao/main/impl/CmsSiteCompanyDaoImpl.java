package com.hx.cms.dao.main.impl;

import org.springframework.stereotype.Repository;

import com.hx.common.hibernate3.HibernateBaseDao;
import com.hx.cms.dao.main.CmsSiteCompanyDao;
import com.hx.cms.entity.main.CmsSiteCompany;

@Repository
public class CmsSiteCompanyDaoImpl extends
		HibernateBaseDao<CmsSiteCompany, Integer> implements CmsSiteCompanyDao {

	public CmsSiteCompany save(CmsSiteCompany bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<CmsSiteCompany> getEntityClass() {
		return CmsSiteCompany.class;
	}
}