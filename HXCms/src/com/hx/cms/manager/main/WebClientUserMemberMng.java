package com.hx.cms.manager.main;

import javax.jws.WebService;

@WebService
public interface WebClientUserMemberMng {
   
	public boolean registerMember(String username, String email,
			String password,String ip, Integer groupId, String encryp);
}
