package com.hx.cms.manager.assist.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hx.cms.dao.assist.CmsCommentDao;
import com.hx.cms.entity.assist.CmsComment;
import com.hx.cms.entity.assist.CmsCommentExt;
import com.hx.cms.manager.assist.CmsCommentExtMng;
import com.hx.cms.manager.assist.CmsCommentMng;
import com.hx.cms.manager.assist.CmsSensitivityMng;
import com.hx.cms.manager.main.CmsSiteMng;
import com.hx.cms.manager.main.CmsTopicMng;
import com.hx.cms.manager.main.CmsUserMng;
import com.hx.cms.manager.main.ContentCountMng;
import com.hx.cms.manager.main.ContentMng;
import com.hx.common.hibernate3.Updater;
import com.hx.common.page.Pagination;

@Service
@Transactional
public class CmsCommentMngImpl implements CmsCommentMng {
	@Transactional(readOnly = true)
	public Pagination getPage(Integer siteId, Integer contentId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int pageNo, int pageSize) {
		Pagination page = dao.getPage(siteId, contentId, greaterThen, checked,
				recommend, desc, pageNo, pageSize, false);
		return page;
	}

	@Transactional(readOnly = true)
	public Pagination getPageForTag(Integer siteId, Integer contentId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int pageNo, int pageSize) {
		Pagination page = dao.getPage(siteId, contentId, greaterThen, checked,
				recommend, desc, pageNo, pageSize, true);
		return page;
	}
	public Pagination getPageForMember(Integer siteId, Integer contentId,Integer toUserId,Integer fromUserId,
			Integer greaterThen, Boolean checked, Boolean recommend,
			boolean desc, int pageNo, int pageSize){
		Pagination page = dao.getPageForMember(siteId, contentId,toUserId,fromUserId, greaterThen, checked,
				recommend, desc, pageNo, pageSize, false);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List<CmsComment> getListForDel(Integer siteId, Integer userId,Integer commentUserId,String ip){
		return dao.getListForDel(siteId,userId,commentUserId,ip);
	}

	@Transactional(readOnly = true)
	public List<CmsComment> getListForTag(Integer siteId, Integer contentId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int count) {
		return dao.getList(siteId, contentId, greaterThen, checked, recommend,
				desc, count, true);
	}
	
	@Transactional(readOnly = true)
	public List<CmsComment> getListForTagTopic(Integer siteId, Integer topicId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int count) {
		return dao.getListTopic(siteId, topicId, greaterThen, checked, recommend,
				desc, count, true);
	}

	@Transactional(readOnly = true)
	public CmsComment findById(Integer id) {
		CmsComment entity = dao.findById(id);
		return entity;
	}

	public CmsComment comment(Short attitude,String text, String ip, Integer contentId,
			Integer siteId, Integer userId, boolean checked, boolean recommend) {
		CmsComment comment = new CmsComment();
		comment.setContent(contentMng.findById(contentId));
		comment.setSite(cmsSiteMng.findById(siteId));
		if (userId != null) {
			comment.setCommentUser(cmsUserMng.findById(userId));
		}
		comment.setChecked(checked);
		comment.setRecommend(recommend);
		comment.setAttitude(attitude);
		comment.init();
		dao.save(comment);
		text = cmsSensitivityMng.replaceSensitivity(text);
		cmsCommentExtMng.save(ip, text, comment);
		contentCountMng.commentCount(contentId);
		return comment;
	}
	
	@Override
	public CmsComment commentTopic(Short attitude,String text, String ip, Integer topicId,
			Integer siteId, Integer userId, boolean checked, boolean recommend) {
		CmsComment comment = new CmsComment();
		comment.setTopic(topicMng.findById(topicId));
		comment.setSite(cmsSiteMng.findById(siteId));
		if (userId != null) {
			comment.setCommentUser(cmsUserMng.findById(userId));
		}
		comment.setChecked(checked);
		comment.setRecommend(recommend);
		comment.setAttitude(attitude);
		comment.init();
		dao.save(comment);
		text = cmsSensitivityMng.replaceSensitivity(text);
		cmsCommentExtMng.save(ip, text, comment);
		/*contentCountMng.commentCount(topicId);*/
		return comment;
	}

	public CmsComment update(CmsComment bean, CmsCommentExt ext) {
		Updater<CmsComment> updater = new Updater<CmsComment>(bean);
		bean = dao.updateByUpdater(updater);
		cmsCommentExtMng.update(ext);
		return bean;
	}

	public int deleteByContentId(Integer contentId) {
		cmsCommentExtMng.deleteByContentId(contentId);
		return dao.deleteByContentId(contentId);
	}

	public CmsComment deleteById(Integer id) {
		CmsComment bean = dao.deleteById(id);
		return bean;
	}

	public CmsComment[] deleteByIds(Integer[] ids) {
		CmsComment[] beans = new CmsComment[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	public void ups(Integer id) {
		CmsComment comment = findById(id);
		comment.setUps((short) (comment.getUps() + 1));
	}

	public void downs(Integer id) {
		CmsComment comment = findById(id);
		comment.setDowns((short) (comment.getDowns() + 1));
	}

	private CmsSensitivityMng cmsSensitivityMng;
	private CmsUserMng cmsUserMng;
	private CmsSiteMng cmsSiteMng;
	private ContentMng contentMng;
	private CmsTopicMng topicMng;
	private ContentCountMng contentCountMng;
	private CmsCommentExtMng cmsCommentExtMng;
	private CmsCommentDao dao;

	@Autowired
	public CmsTopicMng getTopicMng() {
		return topicMng;
	}
	@Autowired
	public void setTopicMng(CmsTopicMng topicMng) {
		this.topicMng = topicMng;
	}

	@Autowired
	public void setCmsSensitivityMng(CmsSensitivityMng cmsSensitivityMng) {
		this.cmsSensitivityMng = cmsSensitivityMng;
	}

	@Autowired
	public void setCmsUserMng(CmsUserMng cmsUserMng) {
		this.cmsUserMng = cmsUserMng;
	}

	@Autowired
	public void setCmsSiteMng(CmsSiteMng cmsSiteMng) {
		this.cmsSiteMng = cmsSiteMng;
	}

	@Autowired
	public void setContentMng(ContentMng contentMng) {
		this.contentMng = contentMng;
	}

	@Autowired
	public void setCmsCommentExtMng(CmsCommentExtMng cmsCommentExtMng) {
		this.cmsCommentExtMng = cmsCommentExtMng;
	}

	@Autowired
	public void setContentCountMng(ContentCountMng contentCountMng) {
		this.contentCountMng = contentCountMng;
	}

	@Autowired
	public void setDao(CmsCommentDao dao) {
		this.dao = dao;
	}

	@Override
	public CmsComment comment(Short attitude, String text, String ip,
			Integer contentId, Integer siteId, Integer userId, boolean checked,
			boolean recommend, Integer commentId) {
		CmsComment comment = new CmsComment();
		comment.setContent(contentMng.findById(contentId));
		comment.setSite(cmsSiteMng.findById(siteId));
		if (userId != null) {
			comment.setCommentUser(cmsUserMng.findById(userId));
		}
		comment.setChecked(checked);
		comment.setRecommend(recommend);
		comment.setAttitude(attitude);
		comment.init();
		dao.save(comment);
		text = cmsSensitivityMng.replaceSensitivity(text);
		cmsCommentExtMng.save(ip, text, comment,commentId);
		contentCountMng.commentCount(contentId);
		return comment;
		
	}
	
	@Override
	public CmsComment commentTopic(Short attitude, String text, String ip,
			Integer topicId, Integer siteId, Integer userId, boolean checked,
			boolean recommend, Integer commentId) {
		CmsComment comment = new CmsComment();
		comment.setTopic(topicMng.findById(topicId));
		comment.setSite(cmsSiteMng.findById(siteId));
		if (userId != null) {
			comment.setCommentUser(cmsUserMng.findById(userId));
		}
		comment.setChecked(checked);
		comment.setRecommend(recommend);
		comment.setAttitude(attitude);
		comment.init();
		dao.save(comment);
		text = cmsSensitivityMng.replaceSensitivity(text);
		cmsCommentExtMng.save(ip, text, comment,commentId);
		/*contentCountMng.commentCount(topicId);*/
		return comment;
		
	}

	@Override
	public List<CmsComment> getListForTag(Integer siteId, Integer contentId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int count, Integer commentId) {
		return dao.getList(siteId, contentId, greaterThen, checked, recommend,
				desc, count, true,commentId);
	}
	
	@Override
	public List<CmsComment> getListForTagTopic(Integer siteId, Integer topicId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int count, Integer commentId) {
		return dao.getListTopic(siteId, topicId, greaterThen, checked, recommend,
				desc, count, true,commentId);
	}


}