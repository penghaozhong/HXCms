package com.hx.cms.manager.main;

import javax.jws.WebService;

import com.hx.cms.entity.main.CmsUser;
import com.hx.cms.entity.main.Content;
import com.hx.cms.entity.main.ContentExt;
import com.hx.cms.entity.main.ContentTxt;

 @WebService
public interface WebServiceContentMng {

		public Content save( Content bean, ContentExt ext, ContentTxt txt,Integer typeId,Boolean draft,CmsUser user,Integer channaId,boolean forMember);

}
