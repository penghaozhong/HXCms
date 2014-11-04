package com.hx.common.util;

import java.util.Comparator;

import com.hx.cms.entity.assist.CmsKeyword;

public class ComparatorKeyWords implements Comparator<Object>{

	@Override
	public int compare(Object arg0, Object arg1) {
		CmsKeyword keyWords1 =(CmsKeyword)arg0;
		CmsKeyword keyWords2 =(CmsKeyword)arg1;
		if(keyWords1.getName().length()>keyWords2.getName().length()){
			return -1;
		}else if (keyWords1.getName().length()==keyWords2.getName().length()){
			return 0;
		}
		else{
			return 1;
		}
		
	}

}
