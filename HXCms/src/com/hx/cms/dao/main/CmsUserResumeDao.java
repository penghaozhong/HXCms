package com.hx.cms.dao.main;

import com.hx.cms.entity.main.CmsUserResume;
import com.hx.common.hibernate3.Updater;

public interface CmsUserResumeDao {
	public CmsUserResume findById(Integer id);

	public CmsUserResume save(CmsUserResume bean);

	public CmsUserResume updateByUpdater(Updater<CmsUserResume> updater);
}