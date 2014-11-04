package com.hx.cms.manager.main;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hx.cms.entity.main.CmsUser;
import com.hx.cms.entity.main.Content;
import com.hx.cms.entity.main.ContentExt;
import com.hx.cms.entity.main.ContentTxt;
import com.hx.cms.entity.main.Content.ContentStatus;
import com.hx.cms.staticpage.exception.ContentNotCheckedException;
import com.hx.cms.staticpage.exception.GeneratedZeroStaticPageException;
import com.hx.cms.staticpage.exception.StaticPageNotOpenException;
import com.hx.cms.staticpage.exception.TemplateNotFoundException;
import com.hx.cms.staticpage.exception.TemplateParseException;
import com.hx.common.page.Pagination;

public interface ContentMng {
	public Pagination getPageByRight(String title, Integer typeId,
			Integer inputUserId, boolean topLevel, boolean recommend,
			ContentStatus status, Byte checkStep, Integer siteId,
			Integer channelId, Integer userId, int orderBy, int pageNo,
			int pageSize);
	/**
	 * @author jacky
	 * @TODO 加入时间查询
	 * @time 2014-09-09 18:47:38
	 * @param title
	 * @param typeId
	 * @param inputUserId
	 * @param topLevel
	 * @param recommend
	 * @param status
	 * @param checkStep
	 * @param siteId
	 * @param channelId
	 * @param userId
	 * @param endDate
	 * @param orderBy
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List getPageByRight(String title, Integer typeId,
			Integer inputUserId, boolean topLevel, boolean recommend,
			ContentStatus status, Byte checkStep, Integer siteId,
			Integer channelId, Integer userId,Date startDate,Date endDate, int orderBy, int pageNo,
			int pageSize);

	/**
	 * 获得文章分页。供会员中心使用。
	 * 
	 * @param title
	 *            文章标题
	 * @param channelId
	 *            栏目ID
	 * @param siteId
	 *            站点ID
	 * @param memberId
	 *            会员ID
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页大小
	 * @return 文章分页对象
	 */
	public Pagination getPageForMember(String title, Integer channelId,
			Integer siteId, Integer memberId, int pageNo, int pageSize);

	/**
	 * 根据内容ID数组获取文章列表
	 * 
	 * @param ids
	 * @param orderBy
	 * @return
	 */
	public List<Content> getListByIdsForTag(Integer[] ids, int orderBy);

	public Content getSide(Integer id, Integer siteId, Integer channelId,
			boolean next);

	public Pagination getPageBySiteIdsForTag(Integer[] siteIds,
			Integer[] typeIds, Boolean titleImg, Boolean recommend,
			String title, int orderBy, int pageNo, int pageSize);

	public List<Content> getListBySiteIdsForTag(Integer[] siteIds,
			Integer[] typeIds, Boolean titleImg, Boolean recommend,
			String title, int orderBy, Integer first, Integer count);

	public Pagination getPageByChannelIdsForTag(Integer[] channelIds,
			Integer[] typeIds, Boolean titleImg, Boolean recommend,
			String title, int orderBy, int option, int pageNo, int pageSize);

	public List<Content> getListByChannelIdsForTag(Integer[] channelIds,
			Integer[] typeIds, Boolean titleImg, Boolean recommend,
			String title, int orderBy, int option, Integer first, Integer count);

	public Pagination getPageByChannelPathsForTag(String[] paths,
			Integer[] siteIds, Integer[] typeIds, Boolean titleImg,
			Boolean recommend, String title, int orderBy, int pageNo,
			int pageSize);

	public List<Content> getListByChannelPathsForTag(String[] paths,
			Integer[] siteIds, Integer[] typeIds, Boolean titleImg,
			Boolean recommend, String title, int orderBy, Integer first,
			Integer count);

	public Pagination getPageByTopicIdForTag(Integer topicId,
			Integer[] siteIds, Integer[] channelIds, Integer[] typeIds,
			Boolean titleImg, Boolean recommend, String title, int orderBy,
			int pageNo, int pageSize);

	public List<Content> getListByTopicIdForTag(Integer topicId,
			Integer[] siteIds, Integer[] channelIds, Integer[] typeIds,
			Boolean titleImg, Boolean recommend, String title, int orderBy,
			Integer first, Integer count);

	public Pagination getPageByTagIdsForTag(Integer[] tagIds,
			Integer[] siteIds, Integer[] channelIds, Integer[] typeIds,
			Integer excludeId, Boolean titleImg, Boolean recommend,
			String title, int orderBy, int pageNo, int pageSize);

	public List<Content> getListByTagIdsForTag(Integer[] tagIds,
			Integer[] siteIds, Integer[] channelIds, Integer[] typeIds,
			Integer excludeId, Boolean titleImg, Boolean recommend,
			String title, int orderBy, Integer first, Integer count);

	public Content findById(Integer id);

	public Content save(Content bean, ContentExt ext, ContentTxt txt,
			Integer[] channelIds, Integer[] topicIds, Integer[] viewGroupIds,
			String[] tagArr, String[] attachmentPaths,String[] attachmentNames2,
			String[] attachmentNames, String[] attachmentFilenames,
			String[] picPaths, Integer channelId, Integer[] tagsIds, 
			Integer typeId, Boolean draft, CmsUser user, boolean forMember);
	

	public Content update(Content bean, ContentExt ext, ContentTxt txt,
			String[] tagArr, Integer[] channelIds, Integer[] topicIds,
			Integer[] viewGroupIds, String[] attachmentPaths,
			String[] attachmentNames, String[] attachmentFilenames,
			String[] picPaths, String[] picDescs, Map<String, String> attr,
			Integer channelId,Integer[] tagsIds, Integer typeId, Boolean draft, CmsUser user,
			boolean forMember);

	public Content check(Integer id, CmsUser user);

	public Content[] check(Integer[] ids, CmsUser user);
	
	public Content update(Content bean);

	public Content reject(Integer id, CmsUser user, Byte step, String opinion);

	public Content[] reject(Integer[] ids, CmsUser user, Byte step,
			String opinion);

	public Content cycle(Integer id);

	public Content[] cycle(Integer[] ids);

	public Content recycle(Integer id);

	public Content[] recycle(Integer[] ids);

	public Content deleteById(Integer id);

	public Content[] deleteByIds(Integer[] ids);

	public Content[] contentStatic(Integer[] ids)
			throws TemplateNotFoundException, TemplateParseException,
			GeneratedZeroStaticPageException, StaticPageNotOpenException,
			ContentNotCheckedException;
	
	public Pagination getPageForCollection(Integer siteId, Integer memberId, int pageNo, int pageSize);
	
	public void updateFileByContent(Content bean,Boolean valid);

	public List<Content> getListTime();

	public List<Content> getListByChannelIdsForTag(Integer[] channelIds,
			Integer[] typeIds, Boolean titleImg, Boolean recommend,
			String title, int orderBy, int option, int first, int count,
			Date format);
}