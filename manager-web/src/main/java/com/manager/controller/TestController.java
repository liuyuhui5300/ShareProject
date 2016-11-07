/* @(#)
 *
 * Project:manager-web
 *
 * Modify Information:
 * =============================================================================
 *   Author         Date           Description
 *   ------------ ---------- ---------------------------------------------------
 *   LIUYUHUI      2016年10月26日        first release
 *
 *
 */
package com.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.service.TestService;


@Controller
public class TestController {
	
	private static Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	
	@RequestMapping(value="/test")
	public String test(){
		try {
			String sayHelloWorld = testService.sayHelloWorld();
			LOG.info(sayHelloWorld);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}

}
