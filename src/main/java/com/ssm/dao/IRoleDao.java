package com.ssm.dao;
import java.util.List;    
import java.util.Map;    
    
import com.ssm.dto.Role;
public interface IRoleDao {
	public Role queryByPrimaryKey(Integer id);    
//    public Role getRoleByName(String name);
//        
//    public List<Role> queryRoleByBatch(Map<String,Object> params);    
//        
//    public void insertRole(Role role);    
//        
//    public void insertRoleByBatch(List<Role> list);    
//        
//    public void deleteByPrimaryKey(Integer id);    
//        
//    public void delteRoleByBatch(Map<String,Object> params);    
//        
//    public void updateByPrimaryKey(Integer id);    
//    
//    public List<Role> getAllRole();    
}
