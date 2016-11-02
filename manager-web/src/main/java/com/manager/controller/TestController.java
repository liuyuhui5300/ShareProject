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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <br>创建日期：2016年10月26日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
@Controller
public class TestController {
	
	@RequestMapping(value="test")
	public String test(){
		return "index";
	}

}
