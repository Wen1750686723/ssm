package com.ssm.service;
import java.util.List;    

import javax.annotation.Resource;    
    
import org.springframework.stereotype.Service;    
    
import com.ssm.dao.ILoginlogDao;
import com.ssm.dto.Loginlog;
import com.ssm.service.ILoginlogService;  
@Service("loginlogService")  
public class LoginServiceImpl implements ILoginlogService {
	@Resource    
    private ILoginlogDao loginlogDao;    
	public Boolean insertlog(Loginlog loginlog){
		return loginlogDao.insertlog(loginlog);    
	}
}