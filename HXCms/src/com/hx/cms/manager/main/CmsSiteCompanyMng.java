package com.hx.cms.manager.main;

import com.hx.cms.entity.main.CmsSite;
import com.hx.cms.entity.main.CmsSiteCompany;

public interface CmsSiteCompanyMng {
	public CmsSiteCompany save(CmsSite site,CmsSiteCompany bean);

	public CmsSiteCompany update(CmsSiteCompany bean);
}