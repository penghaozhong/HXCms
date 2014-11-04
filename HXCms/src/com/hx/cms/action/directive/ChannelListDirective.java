package com.hx.cms.action.directive;

import static com.hx.cms.Constants.TPL_STYLE_LIST;
import static com.hx.cms.Constants.TPL_SUFFIX;
import static com.hx.cms.web.FrontUtils.PARAM_STYLE_LIST;
import static com.hx.common.web.Constants.UTF8;
import static com.hx.common.web.freemarker.DirectiveUtils.OUT_LIST;
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.hx.cms.action.directive.abs.AbstractChannelDirective;
import com.hx.cms.entity.main.Channel;
import com.hx.cms.entity.main.CmsSite;
import com.hx.cms.web.FrontUtils;
import com.hx.common.web.freemarker.DirectiveUtils;
import com.hx.common.web.freemarker.ParamsRequiredException;
import com.hx.common.web.freemarker.DirectiveUtils.InvokeType;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 栏目列表标签
 */
public class ChannelListDirective extends AbstractChannelDirective {
	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "channel_list";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		CmsSite site = FrontUtils.getSite(env);
		Integer parentId = DirectiveUtils.getInt(PARAM_PARENT_ID, params);
		Integer siteId = DirectiveUtils.getInt(PARAM_SITE_ID, params);
		Boolean rand = DirectiveUtils.getBool(PARAM_HAS_RAND, params);
		// ids
		Integer[] ids = DirectiveUtils.getIntArray(PARAM_IDS, params);
		
		if(rand==null){
			rand=false;
		}
		boolean hasContentOnly = getHasContentOnly(params);
		Boolean displayOnly = DirectiveUtils.getBool(PARAM_DISPLAYONLY_ID, params);
		
		if(displayOnly == null){
			displayOnly = true;
		}

		List<Channel> list;
		if (parentId != null) {
			list = channelMng.getChildListForTag(parentId, hasContentOnly,displayOnly,rand);
		} else {
			if (siteId == null) {
				siteId = site.getId();
			}
			if(ids != null){
				list = channelMng.getListByIds(ids, siteId, hasContentOnly);
			}else{
				list = channelMng.getTopListForTag(siteId, hasContentOnly,rand);
			}
		}
		/**
		 * 程序取随机3个栏目
		 * */		 
/*		if(rand){
			List<Channel> newlist = new ArrayList<Channel>();
			if(list != null&&list.size()>0){
				Random random = new Random();
				for(int i=0;i<3;i++){
					int num=random.nextInt(list.size())-1;
					newlist.add(list.get(num));
				}			
				list = newlist;
			}
		}*/

		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(OUT_LIST, DEFAULT_WRAPPER.wrap(list));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		InvokeType type = DirectiveUtils.getInvokeType(params);
		String listStyle = DirectiveUtils.getString(PARAM_STYLE_LIST, params);
		if (InvokeType.sysDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			env.include(TPL_STYLE_LIST + listStyle + TPL_SUFFIX, UTF8, true);
		} else if (InvokeType.userDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			FrontUtils.includeTpl(TPL_STYLE_LIST, site, env);
		} else if (InvokeType.custom == type) {
			FrontUtils.includeTpl(TPL_NAME, site, params, env);
		} else if (InvokeType.body == type) {
			body.render(env.getOut());
		} else {
			throw new RuntimeException("invoke type not handled: " + type);
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}
}
