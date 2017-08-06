package com.ssm.service;
import java.util.List;    

import com.ssm.dto.Admin;
public interface IAdminService {
	public Admin getAdminById(int adminId);    
    
//    public void insertAdmin(Admin admin);    
//    
//    public void addAdmin(Admin admin);    
//    
//    public List<Admin> getAllAdmin();    
    public Admin getAdminByName(String name);
}
