package com.hx.cms.action.member;

import static com.hx.cms.Constants.TPLDIR_MEMBER;
import static com.hx.common.page.SimplePage.cpn;
import static com.hx.core.action.front.LoginAct.RETURN_URL;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;






import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.hx.cms.entity.main.CmsSite;
import com.hx.cms.entity.main.CmsUser;
import com.hx.cms.entity.main.FullCalendar;
import com.hx.cms.manager.main.FullCalendarMng;
import com.hx.cms.web.CmsUtils;
import com.hx.cms.web.FrontUtils;
import com.hx.cms.web.WebErrors;
import com.hx.common.page.Pagination;
import com.hx.common.web.CookieUtils;
import com.hx.common.web.RequestUtils;
import com.hx.common.web.ResponseUtils;

@Controller
public class FullCalendarAct {
	private static final Logger log = LoggerFactory.getLogger(FullCalendarAct.class);
	public static final String MEMBER_CALENDAR = "tpl.memberCalendar";
	public static final String MEMBER_CALENDARADD = "tpl.memberCalendarAdd";
	@RequestMapping("/member/v_list.do")
	public String list(Integer pageNo, HttpServletRequest request, ModelMap model) {
		Pagination pagination = manager.getPage(cpn(pageNo), CookieUtils
				.getPageSize(request));
		model.addAttribute("pagination",pagination);
		model.addAttribute("pageNo",pagination.getPageNo());
		return "FullCalendar/list";
	}

	@RequestMapping(value ="/member/calendar.jspx" ,method = RequestMethod.GET)
	public  String calendar(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		CmsUser user = CmsUtils.getUser(request);
		FrontUtils.frontData(request, model, site);
		if (user == null) {
			return FrontUtils.showLogin(request, model, site);
		}
		return FrontUtils.getTplPath(request, site.getSolutionPath(),
				TPLDIR_MEMBER, MEMBER_CALENDAR);
	}
	
	@RequestMapping(value ="/member/calen.jspx" ,method = RequestMethod.GET)
	public  void calendarList(HttpServletRequest request,HttpServletResponse response, ModelMap model,String myStart) {
		CmsUser user = CmsUtils.getUser(request);
		List list= new ArrayList<>();
		if(myStart!=null){
			if(user!=null){
				list= manager.getList(user.getId(),myStart);	
			}else{
				list= manager.getList(null,myStart);	
			}
		}else{
			if(user!=null){
				list= manager.getList(user.getId(),null);	
			}else{
				list= manager.getList(null,null);	
			}
		}
		ResponseUtils.renderJson(response, JSONArray.toJSON(list).toString());  
	}
	
	@RequestMapping(value ="/member/calenSmall.jspx" ,method = RequestMethod.GET)
	public  void calendarSmallList(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		CmsUser user = CmsUtils.getUser(request);
		List<FullCalendar> list= new ArrayList<>();
		if(user==null){
			list= manager.getList(null,null);	
		}else{
		    list= manager.getList(user.getId(),null);	
		}
		List smallList=new ArrayList<>();
		for (FullCalendar calendar : list) {
			calendar.setTitle("");
			smallList.add(calendar);
		}
			ResponseUtils.renderJson(response, JSONArray.toJSON(smallList).toString());  
		  
	}
	
	@RequestMapping(value ="/member/calendarAdd.jspx" ,method = RequestMethod.GET)
	public  String calendarAdd(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		CmsUser user = CmsUtils.getUser(request);
		FrontUtils.frontData(request, model, site);
		if (user == null) {
			return FrontUtils.showLogin(request, model, site);
		}
		model.addAttribute("date",RequestUtils.getQueryParam(request, "date")) ;
		model.addAttribute("end",RequestUtils.getQueryParam(request, "end")) ;
		model.addAttribute("style",RequestUtils.getQueryParam(request, "style")) ;
		if(RequestUtils.getQueryParam(request, "style").equals("0")){
			
			model.addAttribute("bean",manager.findById(Integer.parseInt(RequestUtils.getQueryParam(request, "id")))) ;
		}
		return FrontUtils.getTplPath(request, site.getSolutionPath(),
				TPLDIR_MEMBER, MEMBER_CALENDARADD);
	}
	
	@RequestMapping("/member/v_add.do")
	public String add(ModelMap model) {
		return "FullCalendar/add";
	}

	@RequestMapping("/member/v_edit.do")
	public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateEdit(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		model.addAttribute("fullCalendar", manager.findById(id));
		model.addAttribute("pageNo",pageNo);
		return "FullCalendar/edit";
	}

	@RequestMapping("/member/calendar_save.jspx")
	public void save(FullCalendar bean, HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		CmsUser user = CmsUtils.getUser(request);
		if(user.getAdmin()){
			bean.setColor("#CCCCCC");
			bean.setUserId(0);
		}else{
			bean.setUserId(user.getId());
		}
		
		manager.save(bean);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print('1');  
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@RequestMapping("/member/calendar_update.jspx")
	public void update(FullCalendar bean, HttpServletResponse response,HttpServletRequest request,
			ModelMap model) {
		
		bean = manager.update(bean);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print('1');  
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/member/calendar_delete.jspx")
	public void delete(HttpServletResponse response,HttpServletRequest request,
			ModelMap model) {
		manager.deleteById(Integer.parseInt(RequestUtils.getQueryParam(request, "id")));
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print('1');  
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/member/calendar_updateDrag.jspx")
	public void updateDrag(HttpServletResponse response,HttpServletRequest request,
			ModelMap model) {
		FullCalendar bean = manager.findById(Integer.parseInt(RequestUtils.getQueryParam(request, "id")));
		CmsUser user = CmsUtils.getUser(request);
		PrintWriter out;
		DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		Date start = null;
		Date end = null;
		Integer daydiff = Integer.parseInt(RequestUtils.getQueryParam(request, "daydiff"));
		try {
			start = dd.parse(bean.getStart());
			end = dd.parse(bean.getEnd());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(start);
		cal1.add(Calendar.DATE,daydiff );
		Date startdiff =	cal1.getTime();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(end);
		cal2.add(Calendar.DATE,daydiff );
		Date enddiff =	cal1.getTime();
		String startdifff = dd.format(startdiff);
		String enddifff = dd.format(enddiff);
		bean.setStart(startdifff);
		bean.setEnd(enddifff);
		if(bean.getUserId()==0){
			if(user!=null){
				if(user.getAdmin()){
					manager.update(bean);
					try {
						out = response.getWriter();
						out.print('1');  
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					try {
						response.setCharacterEncoding("UTF-8");
						out = response.getWriter();
						out.print("系统事件不能更改！");  
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				try {
					response.setCharacterEncoding("UTF-8");
					out = response.getWriter();
					out.print("系统事件不能更改！");  
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else{
			manager.update(bean);
			
			try {
				out = response.getWriter();
				out.print('1');  
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private WebErrors validateEdit(Integer id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		CmsSite site = CmsUtils.getSite(request);
		if (vldExist(id, site.getId(), errors)) {
			return errors;
		}
		return errors;
	}

	private boolean vldExist(Integer id, Integer siteId, WebErrors errors) {
		if (errors.ifNull(id, "id")) {
			return true;
		}
		FullCalendar entity = manager.findById(id);
		if(errors.ifNotExist(entity, FullCalendar.class, id)) {
			return true;
		}
		if (!entity.getSite().getId().equals(siteId)) {
			errors.notInSite(FullCalendar.class, id);
			return true;
		}
		return false;
	}
	
	@Autowired
	private FullCalendarMng manager;
}