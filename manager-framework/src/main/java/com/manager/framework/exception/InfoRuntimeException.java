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
package com.manager.framework.exception;

/**
 * <br>
 * 创建日期：2016年10月25日 <br>
 * <b>Copyright 2016 SHITOU All Rights Reserved</b>
 * 
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class InfoRuntimeException extends ManagerRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5785433836299307300L;

	public InfoRuntimeException() {
		super();
	}

	InfoRuntimeException(String code) {
		super(code);
	}

	public InfoRuntimeException(String code, String msg) {
		super(code, msg);
	}

	@Override
	public String toString() {
		return "InfoRuntimeException [code=" + info.code + ", msg=" + info.msg + "]";
	}
}
