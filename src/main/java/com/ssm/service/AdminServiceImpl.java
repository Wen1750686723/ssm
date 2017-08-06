package com.ssm.service;
import java.util.List;    

import javax.annotation.Resource;    
    
import org.springframework.stereotype.Service;    
    
import com.ssm.dao.IAdminDao;
import com.ssm.dto.Admin;
import com.ssm.service.IAdminService;  
@Service("adminService")  
public class AdminServiceImpl implements IAdminService {
    @Resource    
    private IAdminDao adminDao;    
        
    public Admin getAdminById(int adminId) {    
        return adminDao.queryByPrimaryKey(adminId);    
    }  
    public Admin getAdminByName(String name){
    	return adminDao.getAdminByName(name);    
    }
//    
//    public void insertUser(User user) {    
//        userDao.insertUser(user);    
//    }    
//    
//    public void addUser(User user) {    
//        userDao.insertUser(user);    
//    }    
//    
////    @Override    
//    public List<User> getAllUser() {    
//        return userDao.getAllUser();    
//    } 
}
