package com.hx.cms.dao.assist;

import com.hx.common.hibernate3.Updater;
import com.hx.common.page.Pagination;
import com.hx.cms.entity.assist.CmsJobApply;

public interface CmsJobApplyDao {
	public Pagination getPage(Integer userId, Integer contentId,
			Integer siteId, boolean cacheable, int pageNo, int pageSize);

	public CmsJobApply findById(Integer id);

	public CmsJobApply save(CmsJobApply bean);

	public CmsJobApply updateByUpdater(Updater<CmsJobApply> updater);

	public CmsJobApply deleteById(Integer id);
}