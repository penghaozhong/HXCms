package com.hx.cms.dao.main;

import java.util.List;

import com.hx.cms.entity.main.ContentTag;
import com.hx.common.hibernate3.Updater;
import com.hx.common.page.Pagination;

public interface ContentTagDao {
	public List<ContentTag> getList(Integer count, boolean cacheable);

	public Pagination getPage(String name, int pageNo, int pageSize,
			boolean cacheable);

	public ContentTag findById(Integer id);

	public ContentTag findByName(String name, boolean cacheable);

	public ContentTag save(ContentTag bean);

	public ContentTag updateByUpdater(Updater<ContentTag> updater);

	public ContentTag deleteById(Integer id);

	public int deleteContentRef(Integer id);

	public int countContentRef(Integer id);
	
	/**
	 *根据channelId 查询得到ContentTag
	 * @param channelId
	 * @param pageNo
	 * @param pageSize
	 * @param cacheable
	 * @return
	 */
	public List getPageForChannelId(String name,int channelId, int pageNo, int pageSize,
			boolean cacheable);
	/**
	 *根据channelId 查询得到ContentTag
	 * @param channelId
	 * @return
	 */
	public List<ContentTag> findBychannelId(int channelId);
}