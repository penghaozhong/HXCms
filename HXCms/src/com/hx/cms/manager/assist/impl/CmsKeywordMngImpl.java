package com.hx.cms.manager.assist.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.Node;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hx.cms.dao.assist.CmsKeywordDao;
import com.hx.cms.entity.assist.CmsKeyword;
import com.hx.cms.manager.assist.CmsKeywordMng;
import com.hx.common.util.ComparatorKeyWords;

@Service
@Transactional
public class CmsKeywordMngImpl implements CmsKeywordMng {

	@Transactional(readOnly = true)
	public List<CmsKeyword> getListBySiteId(Integer siteId,
			boolean onlyEnabled, boolean cacheable) {
		List<CmsKeyword> list = dao.getListGlobal(onlyEnabled, cacheable);
		// TODO 关键字分站点？
		// list.addAll(dao.getList(siteId, onlyEnabled, cacheable));
		return list;
	}

	@Transactional(readOnly = true)
	public String attachKeyword(Integer siteId, String txt) {
		if (StringUtils.isBlank(txt)) {
			return txt;
		}
		List<CmsKeyword> list = getListBySiteId(siteId, true, true);
		ComparatorKeyWords  comparator = new ComparatorKeyWords();
		Collections.sort(list, comparator);
		int len = list.size();
		if (len <= 0) {
			return txt;
		}
		

		try {
			Lexer lexer = new Lexer(txt);
			Node node;
			StringBuilder sb = new StringBuilder((int) (txt.length() * 1.2));
			String htmll = null;
			int i =0;
			while ((node = lexer.nextNode()) != null) {
				List<CmsKeyword> remList = new ArrayList<>();
				if(i>=5){
					sb.append(node.toHtml());
				}else{
					if (node instanceof TextNode) {
						for (CmsKeyword k : list) {
							htmll = StringUtils.replaceOnce(node.toHtml(), k.getName(),
									k.getUrl());
							if(!htmll.equals(node.toHtml())){
								for (CmsKeyword cmsKeyword : list) {
									if(k.getName().indexOf(cmsKeyword.getName())!=-1){
										remList.add(cmsKeyword);
									}
								}
								for (CmsKeyword keyword : remList) {
									list.remove(keyword);
								}
								list.remove(k);
								i++;
								break;//break是为了每行只替换一个关键词
							}
						}
						sb.append(htmll);
					} else {
						sb.append(node.toHtml());
					}
				}				
			}
			return sb.toString();
		} catch (ParserException e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional(readOnly = true)
	public CmsKeyword findById(Integer id) {
		CmsKeyword entity = dao.findById(id);
		return entity;
	}

	public CmsKeyword save(CmsKeyword bean) {
		bean.init();
		dao.save(bean);
		return bean;
	}

	public void updateKeywords(Integer[] ids, String[] names, String[] urls,
			Boolean[] disableds) {
		CmsKeyword keyword;
		for (int i = 0, len = ids.length; i < len; i++) {
			keyword = findById(ids[i]);
			keyword.setName(names[i]);
			keyword.setUrl(urls[i]);
			keyword.setDisabled(disableds[i]);
		}
	}

	public CmsKeyword deleteById(Integer id) {
		CmsKeyword bean = dao.deleteById(id);
		return bean;
	}

	public CmsKeyword[] deleteByIds(Integer[] ids) {
		CmsKeyword[] beans = new CmsKeyword[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private CmsKeywordDao dao;

	@Autowired
	public void setDao(CmsKeywordDao dao) {
		this.dao = dao;
	}
}