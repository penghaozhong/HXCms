package com.hx.cms.dao.main;

import com.hx.common.hibernate3.Updater;
import com.hx.cms.entity.main.CmsSiteCompany;

public interface CmsSiteCompanyDao {

	public CmsSiteCompany save(CmsSiteCompany bean);

	public CmsSiteCompany updateByUpdater(Updater<CmsSiteCompany> updater);
}