package com.hx.cms.manager.assist;

import com.hx.cms.entity.assist.CmsGuestbook;
import com.hx.cms.entity.assist.CmsGuestbookExt;

public interface CmsGuestbookExtMng {
	public CmsGuestbookExt save(CmsGuestbookExt ext, CmsGuestbook guestbook);

	public CmsGuestbookExt update(CmsGuestbookExt ext);
}