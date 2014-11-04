package com.hx.cms.dao.assist;

import com.hx.cms.entity.assist.CmsVoteItem;
import com.hx.common.hibernate3.Updater;
import com.hx.common.page.Pagination;

public interface CmsVoteItemDao {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsVoteItem findById(Integer id);

	public CmsVoteItem save(CmsVoteItem bean);

	public CmsVoteItem updateByUpdater(Updater<CmsVoteItem> updater);

	public CmsVoteItem deleteById(Integer id);
}