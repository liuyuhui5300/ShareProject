/* @(#)
 *
 * Project:manager-framework
 *
 * Modify Information:
 * =============================================================================
 *   Author         Date           Description
 *   ------------ ---------- ---------------------------------------------------
 *   LIUYUHUI      2016年10月25日        first release
 *
 *
 */
package com.manager.framework.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.manager.framework.annotation.HttpReqHeader;
import com.manager.framework.exception.ManagerRuntimeExceptionConst;
import com.manager.framework.utils.format.DateFormat;

/**
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class HttpHeaderInterceptor implements HandlerInterceptor{
	
	public static final String ATTRIBUTE_HEADER = "header";
	

	public boolean preHandle(HttpServletRequest webRequest, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = webRequest.getRequestURI();
		if(uri.contains("verifyCode/get")){
			return true;
		}
		//汇付回调不验证
		if(uri.contains("chinapnr/")){
			return true;
		}
		HttpReqHeader reqHeader = new HttpReqHeader();

		String date = webRequest.getHeader("timestamp");
		String clientCode = webRequest.getHeader("clientCode");
		if (StringUtils.isBlank(date) || StringUtils.isBlank(clientCode)) {
			throw ManagerRuntimeExceptionConst.InfoHeaderParamIllegal;
		}
		Date timestamp = DateFormat.parseDateStyle1(date);
		if (timestamp == null) {
			throw ManagerRuntimeExceptionConst.InfoHeaderParamIllegal;
		}
		reqHeader.setTimestamp(timestamp);
		reqHeader.setClientCode(clientCode);

		reqHeader.setModel(webRequest.getHeader("model"));
		reqHeader.setVersion(webRequest.getHeader("version"));
		reqHeader.setImei(webRequest.getHeader("imei"));
		reqHeader.setAppversion(webRequest.getHeader("appversion"));

		webRequest.setAttribute("header", reqHeader);

		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
