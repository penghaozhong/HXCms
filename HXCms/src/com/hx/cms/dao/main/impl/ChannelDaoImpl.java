package com.hx.cms.dao.main.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hx.cms.dao.main.ChannelDao;
import com.hx.cms.entity.main.Channel;
import com.hx.common.hibernate3.Finder;
import com.hx.common.hibernate3.HibernateBaseDao;
import com.hx.common.page.Pagination;

@Repository
public class ChannelDaoImpl extends HibernateBaseDao<Channel, Integer>
		implements ChannelDao {
	@SuppressWarnings("unchecked")
	public List<Channel> getTopList(Integer siteId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable,boolean rand) {
		Finder f = getTopFinder(siteId, hasContentOnly, displayOnly, cacheable,rand);
		if(rand){
			f.setFirstResult(0);
			f.setMaxResults(3);
		}
		return find(f);
	}

	public Pagination getTopPage(Integer siteId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable, int pageNo, int pageSize) {
		Finder f = getTopFinder(siteId, hasContentOnly, displayOnly, cacheable,false);
		return find(f, pageNo, pageSize);
	}

	private Finder getTopFinder(Integer siteId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable,boolean rand) {
		Finder f = Finder.create("from Channel bean");
		if(rand){
			f.append(" where bean.parent.id is not null");
			if (hasContentOnly) {
				f.append(" and bean.hasContent=true");
			}
			if (displayOnly) {
				f.append(" and bean.display=true");
			}
				f.append(" order by  rand() ");
		}else{
			f.append(" where bean.site.id=:siteId and bean.parent.id is null");
			f.setParam("siteId", siteId);
			if (hasContentOnly) {
				f.append(" and bean.hasContent=true");
			}
			if (displayOnly) {
				f.append(" and bean.display=true");
			}
				f.append(" order by bean.priority asc,bean.id asc");
				f.setCacheable(cacheable);
		}		
		return f;
	}

	@SuppressWarnings("unchecked")
	public List<Channel> getTopListByRigth(Integer userId, Integer siteId,
			boolean hasContentOnly) {
		Finder f = Finder.create("select bean from Channel bean");
		f.append(" join bean.users user");
		f.append(" where user.id=:userId and bean.site.id=:siteId");
		f.setParam("userId", userId).setParam("siteId", siteId);
		if (hasContentOnly) {
			f.append(" and bean.hasContent=true");
		}
		f.append(" and bean.parent.id is null");
		f.append(" order by bean.priority asc,bean.id asc");
		return find(f);
	}
	
	
	

	@Override
	public List<Channel> getListByIds(Integer[] ids, Integer siteId,
			boolean hasContentOnly) {
		Finder f = Finder.create("select bean from Channel bean");
		f.append(" where  bean.site.id=:siteId");
		if(ids !=null){
			f.append(" and bean.id in (:ids)");
			f.setParamList("ids", ids);
		}
		f.setParam("siteId", siteId);
		if (hasContentOnly) {
			f.append(" and bean.hasContent=true");
		}
		f.append(" order by bean.priority asc,bean.id asc");
		return find(f);
	}

	@SuppressWarnings("unchecked")
	public List<Channel> getChildList(Integer parentId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable,boolean rand) {
		Finder f = getChildFinder(parentId, hasContentOnly, displayOnly,
				cacheable,rand);
		if(rand){
			f.setMaxResults(3);
		}
		return find(f);
	}

	public Pagination getChildPage(Integer parentId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable, int pageNo, int pageSize) {
		Finder f = getChildFinder(parentId, hasContentOnly, displayOnly,
				cacheable,false);
		return find(f, pageNo, pageSize);
	}

	private Finder getChildFinder(Integer parentId, boolean hasContentOnly,
			boolean displayOnly, boolean cacheable,boolean rand) {
		Finder f = Finder.create("from Channel bean");
		f.append(" where bean.parent.id=:parentId");
		f.setParam("parentId", parentId);
		if (hasContentOnly) {
			f.append(" and bean.hasContent=true");
		}
		if (displayOnly) {
			f.append(" and bean.display=true");
		}
		if(rand){
			f.append(" order by  rand()");
		}else{
		f.append(" order by bean.priority asc,bean.id asc");
		}
		return f;
	}

	@SuppressWarnings("unchecked")
	public List<Channel> getChildListByRight(Integer userId, Integer parentId,
			boolean hasContentOnly) {
		Finder f = Finder.create("select bean from Channel bean");
		f.append(" join bean.users user");
		f.append(" where user.id=:userId and bean.parent.id=:parentId");
		f.setParam("userId", userId).setParam("parentId", parentId);
		if (hasContentOnly) {
			f.append(" and bean.hasContent=true");
		}
		f.append(" order by bean.priority asc,bean.id asc");
		return find(f);
	}

	public Channel findById(Integer id) {
		Channel entity = get(id);
		return entity;
	}

	public Channel findByPath(String path, Integer siteId, boolean cacheable) {
		String hql = "from Channel bean where bean.path=? and bean.site.id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, path).setParameter(1, siteId);
		// 做一些容错处理，因为毕竟没有在数据库中限定path是唯一的。
		query.setMaxResults(1);
		return (Channel) query.setCacheable(cacheable).uniqueResult();
	}

	public Channel save(Channel bean) {
		getSession().save(bean);
		return bean;
	}

	public Channel deleteById(Integer id) {
		Channel entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<Channel> getEntityClass() {
		return Channel.class;
	}
	
//更新栏目实体
	@Override
	public Channel updateChannel(Channel channel) {
		getSession().update(channel);
		return channel;
	}

//获取栏目下tags
	@Override
	public Pagination getPageTag(String name,int channelId, int pageNo,
			int pageSize, boolean cacheable) {
		Finder f = Finder.create("from Channel bean");
			f.append(" where bean.id = :id");
			f.setParam("id", channelId);	
		if (!StringUtils.isBlank(name)) {
			f.append(" and bean.name like :name");
			f.setParam("name", "%" + name + "%");			
		}		
		f.append(" order by bean.id desc");
		return findSetTag(f, pageNo, pageSize);
	}
	/**
	 * 自定义设list显示tag分页
	 * 
	 * @param finder
	 *            Finder对象
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页条数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Pagination findSetTag(Finder finder, int pageNo, int pageSize) {
		int totalCount = countQueryResult(finder);
		Pagination p = new Pagination(pageNo, pageSize, totalCount);
		if (totalCount < 1) {
			p.setList(new ArrayList());
			return p;
		}
		Query query = getSession().createQuery(finder.getOrigHql());
		finder.setParamsToQuery(query);
		query.setFirstResult(p.getFirstResult());
		query.setMaxResults(p.getPageSize());
		if (finder.isCacheable()) {
			query.setCacheable(true);
		}
		List<Channel> list = query.list();
		List mylist=new ArrayList<>();
		Set<Object> tags = new HashSet<Object>();
		for (Object tag : list.get(0).getTags()) {			
			tags.add(tag);
		}
		for (Object object : tags) {
			mylist.add(object);
		}		
		p.setList(mylist);
		return p;
	}
}

