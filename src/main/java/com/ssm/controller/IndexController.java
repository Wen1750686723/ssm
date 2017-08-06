package com.ssm.controller;

import javax.annotation.Resource;

//import java.util.List;    

//import javax.annotation.Resource;    
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;  

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.dto.User;
//import com.ssm.service.IUserService;
//
//import extension.Lwb_httprequest;
import extension.Lwb_list;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.dao.DataAccessException;  
import org.springframework.data.redis.connection.RedisConnection;  
import org.springframework.data.redis.core.RedisCallback;  
import org.springframework.data.redis.serializer.RedisSerializer;  
@Controller
@RequestMapping("/index")
public class IndexController<K, V> {
	@Resource
	public RedisTemplate<K, V> redisTemplate;
	@RequestMapping("/showjsonlist")
	public @ResponseBody User[] showjsonlist(HttpServletRequest request, Model model) {
		User user = new User();
		user.setName(String.valueOf("name"));
		user.setPassword(String.valueOf("password"));
		user.setAge(Integer.parseInt(String.valueOf("1")));
		User user2 = new User();
		user2.setName(String.valueOf("name"));
		user2.setPassword(String.valueOf("password"));
		user2.setAge(Integer.parseInt(String.valueOf("1")));
		User[] a = new User[] { user, user2 };
		return a;
	}

	@RequestMapping("/compare")
	public String compare(HttpServletRequest request, Model model) {
		Lwb_list.compares();
		return "login";
	}

	@RequestMapping("/testthread")
	public String testthread(HttpServletRequest request, Model model) {
		 boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
	            public Boolean doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
	                byte[] key  = serializer.serialize("1111");  
	                byte[] name = serializer.serialize("name");  
	                return connection.setNX(key, name);  
	            }  
	        });
		     
		System.out.println(result);
//		System.out.println(jc.get("age"));
//		System.out.println(jc.get("sex"));
//		Lwb_list.compares();
		return "login";
	}
}
