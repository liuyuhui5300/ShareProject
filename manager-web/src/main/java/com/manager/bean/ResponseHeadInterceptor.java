package com.manager.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**  
* <pre>
* 类描述： 
* 创建人：仲李  
* 联系方式：oathleo@gmail.com  18516152819
* 创建时间：2015年3月28日 下午4:22:43 
* @version 
*  </pre>
*/
public class ResponseHeadInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "must-revalidate");
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { 
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
