package com.ssm.dao;
import java.util.List;    
import java.util.Map;    
    
import com.ssm.dto.Nav;
public interface INavDao {
	public Nav queryByPrimaryKey(Integer id);   
	public List<Nav> queryBySelectKey(List<Integer> key); 
	public List<Nav> queryBySelectKeyshow(List<Integer> key); 
	public List<Nav> getallnav();  
//    public Nav getNavByName(String name);
//        
//    public List<Nav> queryNavByBatch(Map<String,Object> params);    
//        
//    public void insertNav(Nav nav);    
//        
//    public void insertNavByBatch(List<Nav> list);    
//        
//    public void deleteByPrimaryKey(Integer id);    
//        
//    public void delteNavByBatch(Map<String,Object> params);    
//        
//    public void updateByPrimaryKey(Integer id);    
//    
//    public List<Nav> getAllNav();    
}
