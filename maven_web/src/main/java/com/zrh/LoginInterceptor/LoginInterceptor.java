package com.zrh.LoginInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zrh.util.RedisService;

public class LoginInterceptor implements HandlerInterceptor {
	@Resource
	  private RedisService redisService;

	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	      throws Exception {
	    String url=request.getServletPath();
	    Object uid=redisService.get("uid");
	   // System.out.println(uid);
	  
	    if (url.indexOf("/login") >= 0) {
	      
	        return true;
	      
	    }
		
		  if(uid!=null) { return true; }
		 
	    
	    
	  
	    return false;
	  }

	  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	      ModelAndView modelAndView) throws Exception {
	    // TODO Auto-generated method stub
	    
	  }

	  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	      throws Exception {
	    // TODO Auto-generated method stub
	    
	  }
}
