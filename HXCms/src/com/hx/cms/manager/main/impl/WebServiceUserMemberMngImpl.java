package com.hx.cms.manager.main.impl;

import javax.jws.WebService;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hx.cms.dao.main.CmsUserDao;
import com.hx.cms.entity.main.CmsGroup;
import com.hx.cms.entity.main.CmsUser;
import com.hx.cms.entity.main.CmsUserExt;
import com.hx.cms.manager.main.CmsGroupMng;
import com.hx.cms.manager.main.CmsUserExtMng;
import com.hx.cms.manager.main.WebServiceUserMemberMng;
import com.hx.core.entity.UnifiedUser;
import com.hx.core.manager.UnifiedUserMng;

@Service
@Transactional
@WebService(endpointInterface = "com.hx.cms.manager.main.WebServiceUserMemberMng", serviceName = "registerMember")
public class WebServiceUserMemberMngImpl implements WebServiceUserMemberMng {

	@Override
	public void registerMember(String username, String email,
			String password,String ip, Integer groupId, String encrypt) {
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
			return ;
		}
		Session session = dao.getWebServiceSession();
		
		UnifiedUser unifiedUser = null;
		session.beginTransaction().begin();
		UnifiedUser oldUser= unifiedUserMng.getByUsername(username);
		if(oldUser != null){
			// 判断用户是否存在 ,存在则进行更新
			if(password.equals(oldUser.getPassword()) && encrypt.equals(oldUser.getEncrypt())){
				return ;
			}else{
				unifiedUserMng.update(username, password, encrypt);
				return ;
			}
		}
		if (StringUtils.isEmpty(encrypt)) {
			unifiedUser = unifiedUserMng.save(username, email, password, ip);
		} else {
			unifiedUser = unifiedUserMng.save(username, email, password, ip,
					encrypt);
		}

		CmsUser user = new CmsUser();
		user.forMember(unifiedUser);

		CmsGroup group = null;
		if (groupId != null) {
			group = cmsGroupMng.findById(groupId);
		} else {
			group = cmsGroupMng.getRegDef();
		}
		if (group == null) {
			throw new RuntimeException(
					"register default member group not found!");
		}
		user.setGroup(group);
		user.init();
		dao.save(user);
		CmsUserExt userExt = new CmsUserExt();
		cmsUserExtMng.save(userExt, user);
	}

	@Override
	public void updatePassword(String username, String oldPass, String pass,
			String encryp) {
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(oldPass) && StringUtils.isNotBlank(pass) && StringUtils.isNotBlank(encryp)){
			Session session = dao.getWebServiceSession();
			session.beginTransaction().begin();
			UnifiedUser unifiedUser = unifiedUserMng.getByUsername(username);
			if(unifiedUser != null){
				if(unifiedUser.getPassword().equals(oldPass)){
					unifiedUserMng.update(username, pass, encryp);
				}
			}
		}
	}
	
	@Autowired
	private UnifiedUserMng unifiedUserMng;
	@Autowired
	private CmsUserDao dao;
	@Autowired
	private CmsGroupMng cmsGroupMng;
	@Autowired
	private CmsUserExtMng cmsUserExtMng;
	
}
