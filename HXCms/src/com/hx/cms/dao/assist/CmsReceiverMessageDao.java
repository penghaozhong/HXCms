package com.hx.cms.dao.assist;

import java.util.Date;
import java.util.List;

import com.hx.cms.entity.assist.CmsReceiverMessage;
import com.hx.common.page.Pagination;

/**
 *ieforex研发
 */
public interface CmsReceiverMessageDao {

	public Pagination getPage(Integer siteId, Integer sendUserId,
			Integer receiverUserId, String title, Date sendBeginTime,
			Date sendEndTime, Boolean status, Integer box, Boolean cacheable,
			int pageNo, int pageSize);
	
	public List<CmsReceiverMessage> getList(Integer siteId, Integer sendUserId,
			Integer receiverUserId, String title, Date sendBeginTime,
			Date sendEndTime, Boolean status, Integer box, Boolean cacheable);

	public CmsReceiverMessage findById(Integer id);

	public CmsReceiverMessage save(CmsReceiverMessage bean);

	public CmsReceiverMessage update(CmsReceiverMessage bean);

	public CmsReceiverMessage deleteById(Integer id);

	public CmsReceiverMessage[] deleteByIds(Integer[] ids);
}