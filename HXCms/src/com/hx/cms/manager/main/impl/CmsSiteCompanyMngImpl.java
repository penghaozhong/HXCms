package com.hx.cms.manager.main.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hx.common.hibernate3.Updater;
import com.hx.cms.dao.main.CmsSiteCompanyDao;
import com.hx.cms.entity.main.CmsSite;
import com.hx.cms.entity.main.CmsSiteCompany;
import com.hx.cms.manager.main.CmsSiteCompanyMng;

@Service
@Transactional
public class CmsSiteCompanyMngImpl implements CmsSiteCompanyMng {
	public CmsSiteCompany save(CmsSite site,CmsSiteCompany bean) {
		site.setSiteCompany(bean);
		bean.setSite(site);
		dao.save(bean);
		return bean;
	}

	public CmsSiteCompany update(CmsSiteCompany bean) {
		Updater<CmsSiteCompany> updater = new Updater<CmsSiteCompany>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	private CmsSiteCompanyDao dao;

	@Autowired
	public void setDao(CmsSiteCompanyDao dao) {
		this.dao = dao;
	}
}