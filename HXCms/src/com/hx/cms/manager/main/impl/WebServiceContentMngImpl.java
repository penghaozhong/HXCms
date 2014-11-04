package com.hx.cms.manager.main.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.cms.dao.main.ContentDao;
import com.hx.cms.entity.main.CmsSite;
import com.hx.cms.entity.main.CmsUser;
import com.hx.cms.entity.main.Content;
import com.hx.cms.entity.main.ContentCheck;
import com.hx.cms.entity.main.ContentCount;
import com.hx.cms.entity.main.ContentExt;
import com.hx.cms.entity.main.ContentTxt;
import com.hx.cms.manager.assist.CmsCommentMng;
import com.hx.cms.manager.assist.CmsFileMng;
import com.hx.cms.manager.main.ChannelMng;
import com.hx.cms.manager.main.CmsGroupMng;
import com.hx.cms.manager.main.CmsModelMng;
import com.hx.cms.manager.main.CmsTopicMng;
import com.hx.cms.manager.main.CmsUserMng;
import com.hx.cms.manager.main.ContentCheckMng;
import com.hx.cms.manager.main.ContentCountMng;
import com.hx.cms.manager.main.ContentExtMng;
import com.hx.cms.manager.main.ContentTagMng;
import com.hx.cms.manager.main.ContentTxtMng;
import com.hx.cms.manager.main.ContentTypeMng;
import com.hx.cms.manager.main.WebServiceContentMng;
import com.hx.cms.service.ContentListener;
import com.hx.cms.staticpage.StaticPageSvc;

@Service
@WebService
public class WebServiceContentMngImpl implements WebServiceContentMng {
	
	@Override
	public Content save(Content bean, ContentExt ext, ContentTxt txt,
			Integer typeId, Boolean draft, CmsUser user,Integer ibrebatesChannalId, boolean forMember) {
	 
		return null;
	}
	private Content saveContent(Content bean, ContentExt ext, ContentTxt txt,
			Integer channelId,Integer typeId, Boolean draft, CmsUser user, boolean forMember){
		bean.setChannel(channelMng.findById(channelId));
		bean.setType(contentTypeMng.findById(typeId));
		bean.setUser(user);
		Byte userStep;
		if (forMember) {
			// 会员的审核级别按0处理
			userStep = 0;
		} else {
			CmsSite site = bean.getSite();
			userStep = user.getCheckStep(site.getId());
		}
		if (draft != null && draft) {
			bean.setStatus(ContentCheck.DRAFT);
		} else {
			if (userStep >= bean.getChannel().getFinalStepExtends()) {
				bean.setStatus(ContentCheck.CHECKED);
			} else {
				bean.setStatus(ContentCheck.CHECKING);
			}
		}
		// 是否有标题图
		bean.setHasTitleImg(!StringUtils.isBlank(ext.getTitleImg()));
		bean.init();
		// 执行监听器
		 
		dao.save(bean);
		contentExtMng.save(ext, bean);
		contentTxtMng.save(txt, bean);
		ContentCheck check = new ContentCheck();
		check.setCheckStep(userStep);
		contentCheckMng.save(check, bean);
		contentCountMng.save(new ContentCount(), bean);
		return bean;
	}
	
	private List<ContentListener> listenerList;

	public void setListenerList(List<ContentListener> listenerList) {
		this.listenerList = listenerList;
	}
	
	private void preSave(Content content) {
		if (listenerList != null) {
			for (ContentListener listener : listenerList) {
				listener.preSave(content);
			}
		}
	}
	private ChannelMng channelMng;
	private ContentExtMng contentExtMng;
	private ContentTxtMng contentTxtMng;
	private ContentTypeMng contentTypeMng;
	private ContentCountMng contentCountMng;
	private ContentCheckMng contentCheckMng;
	private ContentTagMng contentTagMng;
	private CmsGroupMng cmsGroupMng;
	private CmsUserMng cmsUserMng;
	private CmsTopicMng cmsTopicMng;
	private CmsCommentMng cmsCommentMng;
	private ContentDao dao;
	private StaticPageSvc staticPageSvc;
	private CmsFileMng fileMng;
	@Autowired
	protected CmsModelMng cmsModelMng;

	@Autowired
	public void setChannelMng(ChannelMng channelMng) {
		this.channelMng = channelMng;
	}

	@Autowired
	public void setContentTypeMng(ContentTypeMng contentTypeMng) {
		this.contentTypeMng = contentTypeMng;
	}

	@Autowired
	public void setContentCountMng(ContentCountMng contentCountMng) {
		this.contentCountMng = contentCountMng;
	}

	@Autowired
	public void setContentExtMng(ContentExtMng contentExtMng) {
		this.contentExtMng = contentExtMng;
	}

	@Autowired
	public void setContentTxtMng(ContentTxtMng contentTxtMng) {
		this.contentTxtMng = contentTxtMng;
	}

	@Autowired
	public void setContentCheckMng(ContentCheckMng contentCheckMng) {
		this.contentCheckMng = contentCheckMng;
	}

	@Autowired
	public void setCmsTopicMng(CmsTopicMng cmsTopicMng) {
		this.cmsTopicMng = cmsTopicMng;
	}

	@Autowired
	public void setContentTagMng(ContentTagMng contentTagMng) {
		this.contentTagMng = contentTagMng;
	}

	@Autowired
	public void setCmsGroupMng(CmsGroupMng cmsGroupMng) {
		this.cmsGroupMng = cmsGroupMng;
	}

	@Autowired
	public void setCmsUserMng(CmsUserMng cmsUserMng) {
		this.cmsUserMng = cmsUserMng;
	}

	@Autowired
	public void setCmsCommentMng(CmsCommentMng cmsCommentMng) {
		this.cmsCommentMng = cmsCommentMng;
	}
	
	@Autowired
	public void setFileMng(CmsFileMng fileMng) {
		this.fileMng = fileMng;
	}

	@Autowired
	public void setDao(ContentDao dao) {
		this.dao = dao;
	}

	@Autowired
	public void setStaticPageSvc(StaticPageSvc staticPageSvc) {
		this.staticPageSvc = staticPageSvc;
	}
	
 
}
