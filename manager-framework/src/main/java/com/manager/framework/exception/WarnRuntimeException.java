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
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class WarnRuntimeException extends ManagerRuntimeException {

	WarnRuntimeException(String code) {
		super(code);
	}

	public WarnRuntimeException(String code, String msg) {
		super(code, msg);
	}

	@Override
	public String toString() {
		return "WarnRuntimeException [code=" + info.code + ", msg=" + info.msg + "]";
	}
}
