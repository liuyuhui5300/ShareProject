package com.manager.listener;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

/**
 * 类描述: <br>
 * 创建时间: 2016年4月15日 上午10:46:50 <br>
 * 
 * @author 仲李
 * @version
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
