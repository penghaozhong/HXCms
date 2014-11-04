package com.hx.cms.dao.main;

import com.hx.cms.entity.main.ContentExt;
import com.hx.common.hibernate3.Updater;

public interface ContentExtDao {
	public ContentExt findById(Integer id);

	public ContentExt save(ContentExt bean);

	public ContentExt updateByUpdater(Updater<ContentExt> updater);
}