/* @(#)
 *
 * Project:manager-framework
 *
 * Modify Information:
 * =============================================================================
 *   Author         Date           Description
 *   ------------ ---------- ---------------------------------------------------
 *   LIUYUHUI      2016年10月24日        first release
 *
 *
 */
package com.manager.framework.exception;

import java.io.Serializable;

/**
 * <br>创建日期：2016年10月24日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class ExceptionInfo implements Serializable{

	private static final long serialVersionUID = -8817625033335062331L;
	
	public String code;
	public String msg;

	@Override
	public String toString() {
		return "ExceptionInfo [code=" + code + ", msg=" + msg + "]";
	}
}
