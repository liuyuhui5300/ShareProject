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
package com.manager.framework.log;

/**
 * <br>创建日期：2016年10月24日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public enum LOG_TYPE {

	CONTROLLER_ASPECT("com.manager.framework.controller.aspect"),;

    public String val;

    private LOG_TYPE(String val) {
        this.val = val;
    }
}
