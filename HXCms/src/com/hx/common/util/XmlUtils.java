package com.hx.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.hx.cms.entity.grab.Calendar;

public class XmlUtils{
 
	public static List<Calendar> getXmlData(String url){
		  HttpClient client=new HttpClient();
	      PostMethod postMethod=new PostMethod(url);
	 	   try {
				client.executeMethod(postMethod);
				InputStream in = postMethod.getResponseBodyAsStream();
				//这里的编码规则要与上面的相对应
				BufferedReader br = new BufferedReader(new InputStreamReader(in,"GB2312"));
				String tempbf;
				StringBuffer html = new StringBuffer(100);
				while ((tempbf = br.readLine()) != null) {
					html.append(tempbf +"\n");
				}
				return XmlUtils.readStringXml(html.toString());
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 	   return null;
	}
	
	public static List<Calendar> readStringXml(String xml) {
	         Document doc = null;
        try {
        	  List<Calendar> banks = new ArrayList<Calendar>();
            // 读取并解析XML文档
            // SAXReader就是一个管道，用一个流的方式，把xml文件读出来
            // 下面的是通过解析xml字符串的
        	if(xml.indexOf("<?xml") == -1 || StringUtils.isBlank(xml)){
        		return banks; 
        	}
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点
            Iterator iter = rootElt.elementIterator("calendar"); // 获取根节点下的子节点calendar
          
            // 遍历head节点
            while (iter.hasNext()) {
            	Calendar bank = new Calendar();
                Element recordEle = (Element) iter.next();
                String id = recordEle.elementText("id");
                bank.setCid(id); 
                String date = recordEle.elementText("date");
                bank.setDate(date);
                String time = recordEle.elementText("time");
                bank.setTime(time);
                String currency = recordEle.elementText("currency");
                bank.setCurrency(currency);
                String country = recordEle.elementText("country");
                bank.setCountry(country);
                String event = recordEle.elementText("event");
                bank.setEvent(event);
                String description = recordEle.elementText("description");
                bank.setDescription(description);
                String period = recordEle.elementText("period");
                bank.setPeriod(period);
                String importance = recordEle.elementText("importance");
                bank.setImportance(XmlUtils.getImportance(importance));
                String previous = recordEle.elementText("previous");
                bank.setPrevious(previous);
                String median = recordEle.elementText("median");
                bank.setMedian(median);
                String ifr_actual = recordEle.elementText("ifr_actual");
                bank.setIfr_actual(ifr_actual); 
                bank.setExternaldate(date);  
                banks.add(bank);
             }
            return banks;
        } catch (DocumentException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	public static String getImportance(String importance){
		String fr = "";
		switch (importance) {
		case "H":
			fr = "<font color='#FF0000'>高</font>";
			break;
		case "L":
			fr = "<font color='#0f6f05'>低</font>";
			break;
		case "M":
			fr = "<font color='#0000ff'>中</font>";
			break;
		}
		return fr;
	}
}
