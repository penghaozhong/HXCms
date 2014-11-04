package com.hx.cms.manager.main;

import java.util.Date;

import com.hx.cms.entity.main.CmsConfig;
import com.hx.cms.entity.main.MarkConfig;
import com.hx.cms.entity.main.MemberConfig;

public interface CmsConfigMng {
	public CmsConfig get();

	public void updateCountCopyTime(Date d);

	public void updateCountClearTime(Date d);

	public CmsConfig update(CmsConfig bean);

	public MarkConfig updateMarkConfig(MarkConfig mark);

	public void updateMemberConfig(MemberConfig memberConfig);
}