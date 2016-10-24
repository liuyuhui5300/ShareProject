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

import ErrorCodeConfig.ErrorCodeConfig;

/**
 * <br>创建日期：2016年10月24日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class ManagerRuntimeException extends RuntimeException {

protected ExceptionInfo info = new ExceptionInfo();
	
    public ManagerRuntimeException() {
        super();
    }

    ManagerRuntimeException(String code) {
		super("err code:" + code);
		String msg = ErrorCodeConfig.get(code);
		info.code = code;
		info.msg = msg;
	}

	public ManagerRuntimeException(String code, String msg) {
		super("err code:" + code);
		info.code = code;
		info.msg = msg;
	}

	ManagerRuntimeException(String code, Throwable ta) {
		super("err code:" + code, ta);
		String msg = ErrorCodeConfig.get(code);
		info.code = code;
		info.msg = msg;
	}
	
	public ExceptionInfo getInfo() {
		return info;
	}

	public String getCode() {
		return info.code;
	}

	public String getMsg() {
		return info.msg;
	}
}
