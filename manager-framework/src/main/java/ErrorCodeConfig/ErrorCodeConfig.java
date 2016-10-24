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
package ErrorCodeConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <br>创建日期：2016年10月24日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class ErrorCodeConfig {

	static Properties properties = new Properties();

	static {
		synchronized (properties) {
			// path
			// 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源
			InputStream in = ErrorCodeConfig.class.getResourceAsStream("/config/framework_error_code.properties");
			if (in != null) {
				try {
					properties.load(in);
				} catch (IOException e) {
					System.err.println("读取error code配置文件错误");
					e.printStackTrace();
				}
			} else {
				System.err.println("无法找到error code配置文件");
			}
		}
	}

	private ErrorCodeConfig() {

	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}
