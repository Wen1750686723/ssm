package com.ssm.dao;
import java.util.List;    
import java.util.Map;    
    
import com.ssm.dto.Admin;
public interface IAdminDao {
	public Admin queryByPrimaryKey(Integer id);    
    public Admin getAdminByName(String name);
//        
//    public List<Admin> queryAdminByBatch(Map<String,Object> params);    
//        
//    public void insertAdmin(Admin admin);    
//        
//    public void insertUserByBatch(List<Admin> list);    
//        
//    public void deleteByPrimaryKey(Integer id);    
//        
//    public void delteAdminByBatch(Map<String,Object> params);    
//        
//    public void updateByPrimaryKey(Integer id);    
//    
//    public List<Admin> getAllAdmin();    
}
