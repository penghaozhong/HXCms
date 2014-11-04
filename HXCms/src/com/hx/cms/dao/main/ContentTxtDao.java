package com.hx.cms.dao.main;

import com.hx.cms.entity.main.ContentTxt;
import com.hx.common.hibernate3.Updater;

public interface ContentTxtDao {
	public ContentTxt findById(Integer id);

	public ContentTxt save(ContentTxt bean);

	public ContentTxt updateByUpdater(Updater<ContentTxt> updater);
}