package com.hx.cms.dao.main;

import java.util.List;

import com.hx.cms.entity.main.Channel;
import com.hx.common.hibernate3.Updater;
import com.hx.common.page.Pagination;

public interface ChannelDao {
	public List<Channel> getTopList(Integer siteId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable,boolean rand);

	public Pagination getTopPage(Integer siteId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable, int pageNo, int pageSize);

	public List<Channel> getTopListByRigth(Integer userId, Integer siteId,
			boolean hasContentOnly);
	
	
	/**
	 * TODO 根据栏目ids 查询栏目
	 * @author jacky
	 * @time 2014-09-12 12:28:34
	 * @param ids
	 * @param siteId
	 * @param hasContentOnly
	 * @return
	 */
	public List<Channel> getListByIds(Integer[] ids, Integer siteId,
			boolean hasContentOnly);
	

	public List<Channel> getChildList(Integer parentId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable,boolean rand);

	public Pagination getChildPage(Integer parentId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable, int pageNo, int pageSize);

	public List<Channel> getChildListByRight(Integer userId, Integer parentId,
			boolean hasContentOnly);

	public Channel findByPath(String path, Integer siteId, boolean cacheable);

	public Channel findById(Integer id);

	public Channel save(Channel bean);

	public Channel updateByUpdater(Updater<Channel> updater);
	
	//更新栏目实体
	public Channel updateChannel(Channel channel);
	
	//获取栏目下tags
	public Pagination getPageTag(String name,int channelId, int pageNo,
			int pageSize, boolean cacheable);

	public Channel deleteById(Integer id);
}