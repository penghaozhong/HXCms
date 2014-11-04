package com.hx.cms.dao.main;

import com.hx.cms.entity.main.ContentCheck;
import com.hx.common.hibernate3.Updater;

public interface ContentCheckDao {
	public ContentCheck findById(Long id);

	public ContentCheck save(ContentCheck bean);

	public ContentCheck updateByUpdater(Updater<ContentCheck> updater);
}