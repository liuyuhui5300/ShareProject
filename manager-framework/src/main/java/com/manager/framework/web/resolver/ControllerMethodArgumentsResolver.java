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

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelFactory;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.manager.framework.exception.InfoRuntimeException;
import com.manager.framework.exception.ManagerRuntimeExceptionConst;
import com.manager.framework.exception.WarnRuntimeException;

/**
 * 请求参数对象化并验证 <br>
 * 创建日期：2016年10月25日 <br>
 * <b>Copyright 2016 SHITOU All Rights Reserved</b>
 * 
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class ControllerMethodArgumentsResolver implements HandlerMethodArgumentResolver {

	public boolean supportsParameter(MethodParameter parameter) {
		Annotation[] as = parameter.getParameterAnnotations();
		for (Annotation a : as) {
			if (a.annotationType() == Valid.class) {
				return true;
			}
		}
		return false;
	}

	protected Object createAttribute(String attributeName, MethodParameter parameter,
			WebDataBinderFactory binderFactory, NativeWebRequest request) throws Exception {
		return org.springframework.beans.BeanUtils.instantiateClass(parameter.getParameterType());
	}

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String name = ModelFactory.getNameForParameter(parameter);
		if (StringUtils.isBlank(name)) {
			throw new WarnRuntimeException(ManagerRuntimeExceptionConst.WarnBad.getCode(), "方法定义异常,未找到参数名称");
		}

		Object object = org.springframework.beans.BeanUtils.instantiateClass(parameter.getParameterType());

		WebDataBinder binder = binderFactory.createBinder(webRequest, object, name);
		if (binder.getTarget() != null) {
			bindRequestParameters(binder, webRequest);
			validateIfApplicable(binder, parameter);
			BindingResult bindingResult = binder.getBindingResult();
			if (bindingResult.hasErrors()) {
				FieldError fieldError = bindingResult.getFieldError();
				String meg = fieldError.getDefaultMessage();
				throw new InfoRuntimeException(ManagerRuntimeExceptionConst.InfoParamIllegal.getCode(), meg);
			}
		}
		return object;
	}

	protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
		MutablePropertyValues mpvs = new MutablePropertyValues(request.getParameterMap());
		binder.bind(mpvs);
	}

	protected void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
		Annotation[] annotations = parameter.getParameterAnnotations();
		for (Annotation ann : annotations) {
			if (ann.annotationType().getSimpleName().startsWith("Valid")) {
				Object hints = AnnotationUtils.getValue(ann);
				binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[] { hints });
				break;
			}
		}
	}
}
