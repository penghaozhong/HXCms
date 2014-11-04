package com.hx.cms.manager.main;

import com.hx.cms.entity.main.CmsUser;
import com.hx.cms.entity.main.CmsUserResume;

public interface CmsUserResumeMng {
	public CmsUserResume save(CmsUserResume ext, CmsUser user);

	public CmsUserResume update(CmsUserResume ext, CmsUser user);
}