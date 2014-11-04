package com.hx.cms.manager.main;

import com.hx.cms.entity.main.Content;
import com.hx.cms.entity.main.ContentExt;

public interface ContentExtMng {
	public ContentExt save(ContentExt ext, Content content);

	public ContentExt update(ContentExt ext);
}