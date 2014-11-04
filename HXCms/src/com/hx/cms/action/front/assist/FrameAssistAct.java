package com.hx.cms.action.front.assist;

import static com.hx.cms.Constants.TPLDIR_SPECIAL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hx.cms.entity.main.CmsSite;
import com.hx.cms.manager.main.ChannelMng;
import com.hx.cms.web.CmsUtils;
import com.hx.cms.web.FrontUtils;

@Controller
public class FrameAssistAct {
	
	public static final String TPL_FORUM = "tpl.forum";
	public static final String TPL_COMMUNITY = "tpl.community";
	
	@RequestMapping(value = "/special/forum.jspx")
	public String showForum(HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
		return FrontUtils.getTplPath(request, site.getSolutionPath(),
				TPLDIR_SPECIAL, TPL_FORUM);
	}
	
	@RequestMapping(value = "/special/community.jspx")
	public String showCommunity(HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
		return FrontUtils.getTplPath(request, site.getSolutionPath(),
				TPLDIR_SPECIAL, TPL_COMMUNITY);
	}
	

	
	@Autowired
	private ChannelMng channelMng;
}