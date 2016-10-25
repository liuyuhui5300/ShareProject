package com.manager.listener;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

/**
 * 
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class InitServletContextListener extends ContextLoaderListener {

	public static final Logger LOG = LoggerFactory.getLogger(InitServletContextListener.class);

 
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
        //ProtocolConfig.destroyAll();
	}
}
