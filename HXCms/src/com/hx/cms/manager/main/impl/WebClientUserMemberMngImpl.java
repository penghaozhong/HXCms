package com.hx.cms.manager.main.impl;

import javax.jws.WebService;

import com.hx.cms.manager.main.WebClientUserMemberMng;


@WebService
public class WebClientUserMemberMngImpl implements WebClientUserMemberMng {

	
	@Override
	public boolean registerMember(String username, String email,
			String password,String ip, Integer groupId, String encrypt) {
		return false;
	}

	
}
