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
package com.manager.framework.annotation;

import java.io.Serializable;
import java.util.Date;

/**
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class HttpReqHeader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2877184599690073505L;
	private Date timestamp;

	private String clientCode;

	private String model;

	private String version;

	private String imei;

	private String appversion;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String code) {
		this.clientCode = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getAppversion() {
		return appversion;
	}

	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}

	@Override
	public String toString() {
		return "HttpReqHeader [timestamp=" + timestamp + ", clientCode=" + clientCode + ", model=" + model + ", version=" + version + ", imei=" + imei + ", appversion=" + appversion + "]";
	}

}
