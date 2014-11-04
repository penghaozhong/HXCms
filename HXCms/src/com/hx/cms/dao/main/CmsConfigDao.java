package com.hx.cms.dao.main;

import com.hx.cms.entity.main.CmsConfig;
import com.hx.common.hibernate3.Updater;

public interface CmsConfigDao {
	public CmsConfig findById(Integer id);

	public CmsConfig updateByUpdater(Updater<CmsConfig> updater);
}