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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.manager.framework.exception.ManagerRuntimeException;
import com.manager.framework.exception.WarnRuntimeException;
import com.manager.framework.utils.encoding.Json;

/**
 * <br>
 * 创建日期：2016年10月25日 <br>
 * <b>Copyright 2016 SHITOU All Rights Reserved</b>
 * 
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class ControllerJsonExceptionResolver extends ExceptionHandlerExceptionResolver {

	public static final Logger LOG = LoggerFactory.getLogger(ControllerJsonExceptionResolver.class);

	protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response,
			HandlerMethod handlerMethod, Exception exception) {
		String contentType = request.getContentType();
		if (exception instanceof ManagerRuntimeException) {
			ManagerRuntimeException ex = (ManagerRuntimeException) exception;
			if (ex instanceof WarnRuntimeException) {
				LOG.warn("严重异常", ex);
			} else {
				LOG.warn("业务异常", ex);
			}
			excuteJson(response, ex.getInfo());
		} else {
			LOG.error("未定义异常", exception);
			HashMap<String, String> map = new HashMap<String, String>(2);
			map.put("code", "000001");
			// map.put("msg", exception.getMessage());
			map.put("msg", "系统更新中,请稍后再试 ");
			excuteJson(response, map);
		}
		return new ModelAndView();
	}

	private void excuteJson(HttpServletResponse response, Object exceptionInfo) {
		try {
			String exJson = Json.ToJson(exceptionInfo);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(exJson);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getStackTrace(Throwable aThrowable) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		aThrowable.printStackTrace(printWriter);
		return result.toString();
	}
}
