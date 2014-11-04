package com.hx.cms.entity.main;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.hx.cms.entity.assist.CmsComment;
import com.hx.cms.entity.main.base.BaseCmsTopic;
import com.hx.common.util.DateUtils;

public class CmsTopic extends BaseCmsTopic {
	private static final long serialVersionUID = 1L;

	/**
	 * 获得简短名称，如果不存在则返回名称
	 * 
	 * @return
	 */
	public String getSname() {
		if (!StringUtils.isBlank(getShortName())) {
			return getShortName();
		} else {
			return getName();
		}
	}

	public void init() {
		setReleaseDate(new Timestamp(System.currentTimeMillis()));
		blankToNull();
	}

	public void blankToNull() {
		if (StringUtils.isBlank(getTitleImg())) {
			setTitleImg(null);
		}
		if (StringUtils.isBlank(getContentImg())) {
			setContentImg(null);
		}
		if (StringUtils.isBlank(getShortName())) {
			setShortName(null);
		}
	}

	/**
	 * 从集合中获取ID数组
	 * 
	 * @param topics
	 * @return
	 */
	public static Integer[] fetchIds(Collection<CmsTopic> topics) {
		Integer[] ids = new Integer[topics.size()];
		int i = 0;
		for (CmsTopic g : topics) {
			ids[i++] = g.getId();
		}
		return ids;
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsTopic () {
		super();
	}

	public Integer getCommentsCheckedNum() {
		Set<CmsComment> comments = getComments();
		int num=0;
		if (comments != null) {
			for(CmsComment comment:comments){
				if(!comment.getChecked()){
					num++;
				}
			}
			return num;
		} else {
			return 0;
		}
	}
	
	/**
	 * Constructor for primary key
	 */
	public CmsTopic (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsTopic (
		java.lang.Integer id,
		java.lang.String name,
		java.lang.Integer priority,
		java.lang.Boolean recommend) {

		super (
			id,
			name,
			priority,
			recommend);
	}

	/* [CONSTRUCTOR MARKER END] */

}