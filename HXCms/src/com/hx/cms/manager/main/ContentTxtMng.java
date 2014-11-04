package com.hx.cms.manager.main;

import com.hx.cms.entity.main.Content;
import com.hx.cms.entity.main.ContentTxt;

public interface ContentTxtMng {
	public ContentTxt save(ContentTxt txt, Content content);

	public ContentTxt update(ContentTxt txt, Content content);
}