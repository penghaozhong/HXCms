package com.hx.cms.dao.main;

import com.hx.cms.entity.main.CmsUserExt;
import com.hx.common.hibernate3.Updater;

public interface CmsUserExtDao {
	public CmsUserExt findById(Integer id);

	public CmsUserExt save(CmsUserExt bean);

	public CmsUserExt updateByUpdater(Updater<CmsUserExt> updater);
}