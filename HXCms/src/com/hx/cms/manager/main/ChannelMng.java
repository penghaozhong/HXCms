package com.hx.cms.manager.main;

import java.util.List;
import java.util.Map;

import com.hx.cms.entity.main.Channel;
import com.hx.cms.entity.main.ChannelExt;
import com.hx.cms.entity.main.ChannelTxt;
import com.hx.common.page.Pagination;

/**
 * 栏目管理接口
 */
public interface ChannelMng {
	/**
	 * 获得顶级栏目
	 * 
	 * @param siteId
	 *            站点ID
	 * @param hasContentOnly
	 *            是否只获得有内容的栏目
	 * @return
	 */
	public List<Channel> getTopList(Integer siteId, boolean hasContentOnly);

	public List<Channel> getTopListByRigth(Integer userId, Integer siteId,
			boolean hasContentOnly);

	public List<Channel> getTopListForTag(Integer siteId, boolean hasContentOnly,boolean rand);

	public Pagination getTopPageForTag(Integer siteId, boolean hasContentOnly,
			int pageNo, int pageSize);

	public List<Channel> getChildList(Integer parentId, boolean hasContentOnly);

	public List<Channel> getChildListByRight(Integer userId, Integer siteId,
			Integer parentId, boolean hasContentOnly);

	/**
	 * 查询栏目
	 * 加入 displayOnly参数
	 * @author penghaozhong
	 * 2014-07-08 17:04:36
	 * @param parentId
	 * @param hasContentOnly
	 * @param displayOnly
	 * @return
	 */
	public List<Channel> getChildListForTag(Integer parentId,
			boolean hasContentOnly,boolean displayOnly,boolean rand);
	
	
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

	public Pagination getChildPageForTag(Integer parentId,
			boolean hasContentOnly, int pageNo, int pageSize);

	public Channel findByPath(String path, Integer siteId);

	public Channel findByPathForTag(String path, Integer siteId);

	public Channel findById(Integer id);

	public Channel save(Channel bean, ChannelExt ext, ChannelTxt txt,
			Integer[] viewGroupIds, Integer[] contriGroupIds,
			Integer[] userIds, Integer siteId, Integer parentId, Integer modelId,Integer[]modelIds,String[] tpls);

	public Channel update(Channel bean, ChannelExt ext, ChannelTxt txt,
			Integer[] viewGroupIds, Integer[] contriGroupIds,
			Integer[] userIds, Integer parentId, Map<String, String> attr,Integer[]modelIds,String[] tpls);

	public Channel deleteById(Integer id);

	public Channel[] deleteByIds(Integer[] ids);

	public Channel[] updatePriority(Integer[] ids, Integer[] priority);

	public String checkDelete(Integer id);
	
	//更新栏目实体
	public Channel updateChannel(Channel channel);
	
	//获取栏目下tags
	public Pagination getPageTags(String name,int channelId, int pageNo, int pageSize,
			boolean cacheable);
}