package com.hx.cms.manager.main;

import com.hx.cms.entity.main.CmsUser;
import com.hx.cms.entity.main.CmsUserExt;

public interface CmsUserExtMng {
	public CmsUserExt save(CmsUserExt ext, CmsUser user);

	public CmsUserExt update(CmsUserExt ext, CmsUser user);
}