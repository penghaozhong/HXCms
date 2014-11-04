package com.hx.cms.manager.main;

import javax.jws.WebService;

@WebService
public interface WebServiceUserMemberMng {
   
	public void registerMember(String username, String email,
			String password,String ip, Integer groupId, String encryp);
	public void updatePassword(String username,String oldPass,String pass,String encryp);
}
