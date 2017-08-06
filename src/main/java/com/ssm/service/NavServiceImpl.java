package com.ssm.service;
import java.util.List;    

import javax.annotation.Resource;    
    
import org.springframework.stereotype.Service;    
    
import com.ssm.dao.INavDao;
import com.ssm.dto.Nav;
import com.ssm.service.INavService; 
@Service("navService")  
public class NavServiceImpl implements INavService{
	@Resource
	public INavDao navdao;
	public Nav getNavById(int navId){
		return navdao.queryByPrimaryKey(navId);   
	}
	public List<Nav> getNavBykey(List<Integer> navkey){
		return navdao.queryBySelectKey(navkey);   
	}
	public List<Nav> getallnav(){
		return navdao.getallnav();   
	}
	public List<Nav> queryBySelectKeyshow(List<Integer> navkey){
		return navdao.queryBySelectKeyshow(navkey);   
	}
}
