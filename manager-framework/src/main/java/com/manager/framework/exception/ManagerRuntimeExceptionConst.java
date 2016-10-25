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
public class ManagerRuntimeExceptionConst {

	// 通用 000000
	public static final WarnRuntimeException WarnBad = new WarnRuntimeException("000001");
	public static final WarnRuntimeException WarnKryo = new WarnRuntimeException("000006");
	// 通用
	public static final InfoRuntimeException InfoParamIllegal = new InfoRuntimeException("000002");
	public static final InfoRuntimeException InfoParamAuthorizationMiss = new InfoRuntimeException("000003");
	public static final InfoRuntimeException InfoHeaderParamIllegal = new InfoRuntimeException("000004");
	public static final InfoRuntimeException InfoAuthorizationIllegal = new InfoRuntimeException("000005");

}
