package com.ssm.service;
import java.util.List;    

import javax.annotation.Resource;    
    
import org.springframework.stereotype.Service;    
    
import com.ssm.dao.IRoleDao;    
import com.ssm.dto.Role;    
import com.ssm.service.IRoleService; 
@Service("roleService")  
public class RoleServiceImpl implements IRoleService{
	@Resource
	public IRoleDao roledao;
	public Role getRoleById(int roleId){
		return roledao.queryByPrimaryKey(roleId);   
	}
}
