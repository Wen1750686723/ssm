package com.ssm.service;

import java.util.List;

import com.ssm.dto.Nav; 
public interface INavService {
	public Nav getNavById(int navId);    
	public List<Nav> getNavBykey(List<Integer> key);   
	public List<Nav> queryBySelectKeyshow(List<Integer> key); 
	public List<Nav> getallnav();  
}
