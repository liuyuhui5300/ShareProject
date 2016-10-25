package com.manager.listener;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

/**
 * 
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
@Component
public class InitCompoment implements InitializingBean, ServletContextAware {

	public static final Logger LOG = LoggerFactory.getLogger(InitCompoment.class);

	
	
	@Override
	public void afterPropertiesSet() throws Exception {
	
	}

	@Override
	public void setServletContext(ServletContext servletContext) {

	}

}
