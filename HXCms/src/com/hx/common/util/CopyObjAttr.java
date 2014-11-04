package com.hx.common.util;
import java.lang.reflect.Field;
public class CopyObjAttr {
	
	public static void cpoyObjAttr(Object sourceObj,Object targetObj, Class<?> clazz)throws Exception{  
        if(sourceObj==null || targetObj==null){  
            throw new Exception("源对象和目标对象不能为null");  
        }  
        Field[] fields=clazz.getDeclaredFields();  
        for(int i = 0; i < fields.length; i++){  
             fields[i].setAccessible(true);  
             Object sourceValue=fields[i].get(sourceObj);  
             fields[i].set(targetObj,sourceValue );  
        }  
        if(clazz.getSuperclass()==Object.class){  
            return;  
        }  
        cpoyObjAttr(sourceObj,targetObj,clazz.getSuperclass());  
           
    }  

}
