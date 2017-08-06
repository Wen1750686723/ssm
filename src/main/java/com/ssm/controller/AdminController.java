package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;    

import javax.annotation.Resource;    
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;  
    
import org.springframework.stereotype.Controller;    
import org.springframework.ui.Model;    
import org.springframework.web.bind.annotation.RequestMapping;    
    
import com.ssm.dto.User;   
import com.ssm.dto.Admin; 
import com.ssm.dto.Nav; 
import com.ssm.dto.Role; 
import com.ssm.dto.Loginlog; 
import com.ssm.service.IUserService;
import com.ssm.service.IAdminService;
import com.ssm.service.INavService;
import com.ssm.service.ILoginlogService;
import com.ssm.service.IRoleService;
import extension.Lwb_NetworkUtil;

//import extension.Lwb_httprequest;
import extension.Lwb_json;

//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import extension.MD5Utils;
import extension.Lwb_timeutil;
import extension.Lwb_stringutil;
import extension.json.Student;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping("/admin")  
public class AdminController {
	@Resource    
    private IUserService userService;   
	@Resource    
    private IAdminService adminService; 
	@Resource    
    private ILoginlogService loginlogService; 
	@Resource    
    private INavService navService; 
	@Resource    
    private IRoleService roleService;
	@RequestMapping("/loginUser")    
    public String loginUser(HttpServletRequest request,Model model){  
//	    	 HttpSession session = request.getSession();
//	    	 session.setAttribute("userid", "1");
//		List<Integer> navList = new ArrayList<Integer>();
//		navList.add(1);
//		navList.add(2);
//		navList.add(3);
//		System.out.print(navService.getNavBykey(navList));
		String err=request.getParameter("err");
		if(err==null){
			model.addAttribute("errs", "");
		}
		else if(err.equals("1")){
			model.addAttribute("errs", "(用户名不能为空)");    
		}else if(err.equals("2")){
			model.addAttribute("errs", "(密码不正确)");    
		}else if(err.equals("3")){
			model.addAttribute("errs", "(无此用户)");    
		}
        return "admin/login";    
    }  
    @RequestMapping("/loginCheck")    
    public String loginCheck(HttpServletRequest request,Model model){  
//    	 User user=userService.getUserByName(request.getParameter("name"));
    	 String name=request.getParameter("name");
    	 Loginlog loginlog=new Loginlog();
    	 loginlog.setIp(Lwb_NetworkUtil.getIpAddress(request));
    	 loginlog.setSafari(Lwb_NetworkUtil.getUserAgent(request));
    	 loginlog.setTime(Lwb_timeutil.getcurrenttime());
    	 
    	 int type;
    	 if(name!=null && name!=""){
    		 Admin admin=adminService.getAdminByName((name));
    		 System.out.println(admin);
    		 if(admin==null){
    			 type=3;
    			 loginlog.setUserid(0);
    			 
    		 }else{
    			 loginlog.setUserid(admin.getUser_id());
    			 String password=admin.getPassword();
        		 if(MD5Utils.md5(request.getParameter("password")).equals(password)){
            		 System.out.println(password);
            		 HttpSession session = request.getSession();
            		 session.setAttribute("username", name);
            		 type=0;
             		 Integer roleid=admin.getRole_id();
             		 Role role=roleService.getRoleById(roleid);
             		 String actionlist=role.getAction_list();
             		 List<Nav> navlistown=navService.getNavBykey(Lwb_stringutil.getfromstring(actionlist));
             		 List<Nav> navlist=navService.getallnav();
             		 Lwb_json.getnavlistfromjson(Lwb_json.navlistbuildjson(navlist));
             		 System.out.println(Lwb_json.navlistbuildjson(navlist));
             		 System.out.println(navlistown);
             		 System.out.println(navlist);
             		 session.setAttribute("navlistown", Lwb_json.navlistbuildjson(navlistown));
             		 session.setAttribute("navlist", Lwb_json.navlistbuildjson(navlist));
             		 
        		 }else{
        			 type=2;
        			 
        		 } 
    		 }
    		 
    	 }else{
    		 type=1;
    		   
    	 }
    	 loginlogService.insertlog(loginlog);
    	 if(type==1){
    		 return "redirect:/admin/loginUser?err=1"; 
    	 }else if(type==2){
    		 return "redirect:/admin/loginUser?err=2";  
    	 }else if(type==3){
    		 return "redirect:/admin/loginUser?err=3"; 
    	 }else{
    		 return "redirect:/admin/main"; 
    	 }
    } 
    @RequestMapping("/logout")    
    public String logout(HttpServletRequest request,Model model){  
    	
    	HttpSession session = request.getSession();
    	session.removeAttribute("username");
    	session.removeAttribute("menu");
    	return "redirect:/admin/main"; 
    } 
    @RequestMapping("/userList")    
    public String userList(HttpServletRequest request,Model model){  
    	
        List<User> uList = userService.getAllUser();    
        model.addAttribute("uList", uList);    
        System.out.println(uList);
        System.out.println(uList);
        return "userList";    
    } 
    @RequestMapping("/navList")    
    public String navList(HttpServletRequest request,Model model){  
    	
    	List<Integer> navList = new ArrayList<Integer>();
		navList.add(1);
		navList.add(2);
		navList.add(3);
		System.out.print(navService.getNavBykey(navList));
        return "user/login"; 
    } 
    @RequestMapping("/main")    
    public String main(HttpServletRequest request,Model model){  
    	HttpSession session = request.getSession();
		String name=session.getAttribute("username").toString();
		model.addAttribute("name", name);    
//    	List<Integer> navList = new ArrayList<Integer>();
//		navList.add(1);
//		navList.add(2);
//		navList.add(3);
//		System.out.print(navService.getNavBykey(navList));
        return "frame/main"; 
    } 
    @RequestMapping(value="/getmenu", produces = "application/json; charset=utf-8")    
    public @ResponseBody String getmenu(HttpServletRequest request,Model model){  
    	
    	HttpSession session = request.getSession();
    	String menu=(String)session.getAttribute("menu");
    	if(menu!=null){
    		return menu;
    	}else{
    		String name=session.getAttribute("username").toString();
    		Admin admin=adminService.getAdminByName((name));
    		Integer roleid=admin.getRole_id();
    		Role role=roleService.getRoleById(roleid);
    		String actionlist=role.getAction_list();
    		String menus=Lwb_json.BuildMenu(navService.queryBySelectKeyshow(Lwb_stringutil.getfromstring(actionlist)));
    		session.setAttribute("menu", menus);
    		return menus;
    	}
		
//    	list<Nav> navlist=navService.get 
    }
    @RequestMapping("/menu")    
    public String menu(HttpServletRequest request,Model model){    
//    	List<Integer> navList = new ArrayList<Integer>();
//		navList.add(1);
//		navList.add(2);
//		navList.add(3);
//		System.out.print(navService.getNavBykey(navList));
        return "admin/menu"; 
    } 
    @RequestMapping("/menuedit")    
    public String menuedit(HttpServletRequest request,Model model){    
//    	List<Integer> navList = new ArrayList<Integer>();
//		navList.add(1);
//		navList.add(2);
//		navList.add(3);
//		System.out.print(navService.getNavBykey(navList));
        return "admin/menuedit"; 
    } 
	 
}
