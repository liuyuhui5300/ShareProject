package com.manager.listener;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

/**
 * 类描述: <br>
 * 创建时间: 2016年5月18日 下午7:05:07 <br>
 * 
 * @author 仲李
 * @version
 */
public class InitServletContextListener extends ContextLoaderListener {

	public static final Logger LOG = LoggerFactory.getLogger(InitServletContextListener.class);

 
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
        //ProtocolConfig.destroyAll();
	}
}
