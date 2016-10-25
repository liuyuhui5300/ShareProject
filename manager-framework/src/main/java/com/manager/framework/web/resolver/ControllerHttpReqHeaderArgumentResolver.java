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
package com.manager.framework.web.resolver;

import java.lang.annotation.Annotation;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.manager.framework.annotation.HttpHeader;
import com.manager.framework.annotation.HttpReqHeader;
import com.manager.framework.exception.ManagerRuntimeExceptionConst;
import com.manager.framework.web.interceptor.HttpHeaderInterceptor;

/**
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class ControllerHttpReqHeaderArgumentResolver implements HandlerMethodArgumentResolver  {

	public boolean supportsParameter(MethodParameter parameter) {
		Annotation[] as = parameter.getParameterAnnotations();
		for (Annotation a : as) {
			if (a.annotationType() == HttpHeader.class) {
				return true;
			}
		}
		return false;
	}

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpReqHeader reqHeader = (HttpReqHeader) webRequest.getAttribute(HttpHeaderInterceptor.ATTRIBUTE_HEADER, RequestAttributes.SCOPE_REQUEST);
		if (reqHeader == null) {
			throw ManagerRuntimeExceptionConst.InfoHeaderParamIllegal;
		}

		return reqHeader;
	}

}
