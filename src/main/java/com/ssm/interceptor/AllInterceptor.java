package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.util.ArrayList;
import java.util.List;      
import org.springframework.web.servlet.HandlerInterceptor;  
import org.springframework.web.servlet.ModelAndView;  
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;  
import com.ssm.dto.Nav;

import extension.Lwb_json;
public class AllInterceptor implements HandlerInterceptor {  
	private static final Logger logger = Logger.getLogger(AllInterceptor.class);  
  
    /** 
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在 
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在 
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返 
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。 
     */  
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
        // TODO Auto-generated method stub  
//    	byte[] bytes = new byte[1024 * 1024];  
//        InputStream is = request.getInputStream();  
//
//        int nRead = 1;  
//        int nTotalRead = 0;  
//        while (nRead > 0) {  
//            nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);  
//            if (nRead > 0)  
//                nTotalRead = nTotalRead + nRead;  
//        }  
//        String str = new String(bytes, 0, nTotalRead, "utf-8");  
//        System.out.println("Str:" + str);  
    	long startTime = System.currentTimeMillis();  
        request.setAttribute("startTime", startTime);  
    	HttpSession session = request.getSession();
    	String username=(String)session.getAttribute("username");
    	String requestURI = request.getRequestURI();  
    	String uri = requestURI.substring(requestURI.lastIndexOf("/"));  
    	String url=(String)requestURI;
      	System.out.print(url);
//    	return true;
    	if(requestURI.contains("admin"))
    	{
    		if(username!=null){
    			try
		        {
    				ArrayList<Nav> navlistown=Lwb_json.getnavlistfromjson(session.getAttribute("navlistown").toString());
	    			ArrayList<Nav> navlist=Lwb_json.getnavlistfromjson(session.getAttribute("navlist").toString());
	    			int ownlisttag=0;
	    			int listtag=0;
//	    			System.out.println(navlistown);
//	    			System.out.println(navlist);
	    			for(Nav attribute : navlistown) {
	    				if(attribute.getUrl().equals(url)){
	    					ownlisttag=1;
	    					break;
	    				}
					}
	    			if(ownlisttag==1){
	    				return true;
	    			}
	    			for(Nav attribute1 : navlist) {
	    				if(attribute1.getUrl().equals(url)){
	    					listtag=1;
	    					break;
	    				}
					}
	    			if(listtag==1){
	    				response.sendRedirect(request.getContextPath()+"/admin/loginUser");  
	            		return false;
	    			}
//	    			System.out.println(listtag);
//	    			System.out.println(ownlisttag);
//	    			System.out.println(url);
		        }
		        catch (Exception e)
		        {
		            System.out.println("testEx, catch exception");
		        }
    			
    			return true;
        	}else{
        		if (uri.startsWith("/login") || uri.startsWith("/imageLogin") || uri.startsWith("/checkLogin")) {  
                    return true;  
                } else {  
                    // 非法请求 重定向到登录页面  
                	response.sendRedirect(request.getContextPath()+"/admin/loginUser");  
            		return false;
                } 
        		
        	}
    	}else{
    		if(username!=null){
        		return true;
        	}else{
        		if (uri.startsWith("/login") || uri.startsWith("/imageLogin") || uri.startsWith("/checkLogin")) {  
                    return true;  
                } else {  
                    // 非法请求 重定向到登录页面  
                	response.sendRedirect(request.getContextPath()+"/user/loginUser");  
            		return false;
                } 
        		
        	}
    	}
    	
//   	 session.setAttribute("userid", "1");
    	//System.out.println("preHandle---");
//        return true;  
    }  
      
    /** 
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操 
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像， 
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor 
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。 
     */  
    @Override  
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {  
//    	System.out.println("postHandle---");
        // TODO Auto-generated method stub  
    	long startTime = (Long)request.getAttribute("startTime");  
    	  
        long endTime = System.currentTimeMillis();  
  
        long executeTime = endTime - startTime;  
  
        //modified the exisitng modelAndView  
//        modelAndView.addObject("executeTime",executeTime);  
  
        //log it  
//        System.out.println("[" + handler + "] executeTime : " + executeTime + "ms");
        if(logger.isDebugEnabled()){  
           logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");  
        }  
          
    }  
  
    /** 
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行， 
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。 
     */  
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
    throws Exception {  
//    	System.out.println("afterCompletion---");
        // TODO Auto-generated method stub  
          
    }  
      
} 