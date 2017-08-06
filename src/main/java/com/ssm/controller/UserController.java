package com.ssm.controller;

import java.util.List;    

import javax.annotation.Resource;    
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;  
    
import org.springframework.stereotype.Controller;    
import org.springframework.ui.Model;    
import org.springframework.web.bind.annotation.RequestMapping;    
    
import com.ssm.dto.User;    
import com.ssm.service.IUserService;

//import extension.Lwb_httprequest;
import extension.Lwb_json;

//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ResponseBody;
    
@Controller  
@RequestMapping("/user")    
public class UserController {    
    @Resource    
    private IUserService userService;    
    @Resource
    private String baseurl;
    
    @RequestMapping("/showCookies")  
    public void showCookies(HttpServletRequest request,HttpServletResponse response ){  
           
//        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组  
//        if (null==cookies) {  
//            System.out.println("没有cookie=========");  
//        } else {  
//            for(Cookie cookie : cookies){  
//                System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());  
//            }  
//        }  
    	 HttpSession session = request.getSession();
    	//将数据存储到session中
//    	 session.setAttribute("data", "孤傲苍狼");
//    	//获取session的Id
//    	 String sessionId = session.getId();
    	 System.out.println(session.getAttribute("data"));
    	//判断session是不是新创建的
//    	 if (session.isNew()) {
//    		 System.out.println("session创建成功，session的id是："+sessionId);
//    	 }else {
//    		 System.out.println("服务器已经存在该session了，session的id是："+sessionId);
//    	 }
    	// System.out.println(Lwb_httprequest.sendGet("http://www.baidu.com",""));
    	 Lwb_json.ParseJson(Lwb_json.BuildJson());
           
    }     
    @RequestMapping("/userList")    
    public String userList(HttpServletRequest request,Model model){  
    	
        List<User> uList = userService.getAllUser();    
        model.addAttribute("uList", uList);    
        System.out.println(uList);
        System.out.println(uList);
        return "userList";    
    }    
    @RequestMapping("/loginUser")    
    public String loginUser(HttpServletRequest request,Model model){  
//    	 HttpSession session = request.getSession();
//    	 session.setAttribute("userid", "1");
        return "user/login";    
    }  
    @RequestMapping("/loginCheck")    
    public String loginCheck(HttpServletRequest request,Model model){  
    	 User user=userService.getUserByName(request.getParameter("name"));
    	 System.out.print(user);
    	 HttpSession session = request.getSession();
    	 session.setAttribute("username", "1");
         return "redirect:/user/userList";    
    } 
    @RequestMapping("/showUser")    
    public String showUser(HttpServletRequest request,Model model){    
        int userId = Integer.parseInt(request.getParameter("id"));    
        System.out.println(request.getSession());
        User user = userService.getUserById(userId);    
        System.out.println(user);
        System.out.println(user.getId());
        model.addAttribute("user", user);    
        return "showUser";    
    }    
        
    @RequestMapping("/addUserUI")    
    public String addUserUI(){    
        return "addUser";    
    }    
        
    @RequestMapping("/addUser")    
    public String addUser(HttpServletRequest request,Model model){    
        User user = new User();    
        user.setName(String.valueOf(request.getParameter("name")));    
        user.setPassword(String.valueOf(request.getParameter("password")));    
        user.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));    
        userService.addUser(user);    
        return "redirect:/user/userList";    
    } 
       
    @RequestMapping("/showjson")    
    public @ResponseBody User showjson(HttpServletRequest request,Model model){    
        User user = new User();    
        user.setName(String.valueOf("name"));    
        user.setPassword(String.valueOf("password"));    
        user.setAge(Integer.parseInt(String.valueOf("1")));    
        
        return user;    
    } 
    @RequestMapping("/showjsonlist")    
    public @ResponseBody User[] showjsonlist(HttpServletRequest request,Model model){    
        User user = new User();    
        user.setName(String.valueOf("name"));    
        user.setPassword(String.valueOf("password"));    
        user.setAge(Integer.parseInt(String.valueOf("1")));    
        User user2 = new User();    
        user2.setName(String.valueOf("name"));    
        user2.setPassword(String.valueOf("password"));    
        user2.setAge(Integer.parseInt(String.valueOf("1")));  
        User []a = new User[]{user,user2};
        return a;    
    }
}
