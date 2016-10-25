package com.manager.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

   /* private static final Logger      LOG               = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    private static final String      POST              = "post";

    private static final String      JSON_CONTENT_TYPE = "application/json; charset=utf-8";

    @Autowired
    private AccessToken2UserRedisDao accessToken2UserRedisDao;

    @Autowired
    private SysConfigService         sysConfigService;

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {

    }

    public void postHandle(HttpServletRequest req, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String method = request.getMethod();

        String uri = request.getRequestURI();
        if (uri.contains("user/logout")) {
            return true;
        }

        if (uri.contains("accountfund/createFile")) {
            return true;
        }

        // 只有 post方法的header传递 access_token
        if (POST.equals(method.toLowerCase())) {
            String authorization = request.getHeader(Constants.REQUEST_HEAD_PARAM_ACCESSTOKEN);
            if (StringUtils.isBlank(authorization)) {
                // 参数不完整
                responseException(response, new ExceptionJsonObject(ResConstants.SYSTEM_TOKEN_MISSING.getCode(), ResConstants.SYSTEM_TOKEN_MISSING.getMsg()));
                return false;
            }

            UserAuthorization user;
            if (RequestUtils.isFromApp(request)) {
                user = accessToken2UserRedisDao.getAppUserAuthorization(authorization);
                if (user == null) {
                    // Token不存在 非法登录
                    responseException(response, new ExceptionJsonObject(ResConstants.ILLEGAL_ACCESS.getCode(), ResConstants.ILLEGAL_ACCESS.getMsg()));
                    return false;
                }

                int clientType = user.getClientType();
                if (clientType == 2) {
                    //移动iOS 版本
                    String versionString = request.getHeader("version");
                    if (StringUtils.isBlank(versionString)) {
                        versionString = "0";
                    }
                    float version = Float.parseFloat(versionString);

                    SysConfig iosVersion = sysConfigService.getSysConfigByKey("APP_VERSION_CODE_IOS");
                    if (iosVersion == null) {
                        LOG.warn("数据库表SysConfig缺少APP_VERSION_CODE_IOS项");
                    } else {
                        String iosVersionString = iosVersion.getSysValue();
                        float serverVersion = Float.parseFloat(iosVersionString);
                        if (serverVersion > version) {
                            //服务器版本较高
                            responseException(response, new ExceptionJsonObject(ResConstants.SYSTEM_VERSION_UPDATE.getCode(), ResConstants.SYSTEM_VERSION_UPDATE.getMsg()));
                            return false;
                        } else {
                            //正常情况
                        }
                    }
                }

                return handleAppAuthorization(request, response, user);
            } else {
                // from web
                user = accessToken2UserRedisDao.getWebUserAuthorization(authorization);
                if (user == null) {
                    // Token不存在 非法登录
                    responseException(response, new ExceptionJsonObject(ResConstants.ILLEGAL_ACCESS.getCode(), ResConstants.ILLEGAL_ACCESS.getMsg()));
                    return false;
                }
                return handleWebAuthorization(request, response, user);
            }
        }
        // 参数不合法
        responseException(response, new ExceptionJsonObject(ResConstants.PARAM_ILLEGAL.getCode(), ResConstants.PARAM_ILLEGAL.getMsg()));
        return false;
    }

    //Token和最后操作时间无关
    private boolean handleAppAuthorization(HttpServletRequest request, HttpServletResponse response, UserAuthorization user) throws JsonProcessingException, IOException {
        // 判断登录时间
        long lastCallTime = user.getLoginTime();
        long now = System.currentTimeMillis();
        //        if (now - lastCallTime > 1000 * 60 * 60 * 12) {
        if (now - lastCallTime > 1000 * 60 * 60 * 2) {
            //登录超过2小时则过期
            responseException(response, new ExceptionJsonObject(ResConstants.SYSTEM_TOKEN_EXPIRED.getCode(), ResConstants.SYSTEM_TOKEN_EXPIRED.getMsg()));
            return false;
        } else {
            user.setLastCallTime(System.currentTimeMillis());
            // 更新token的操作时间
            accessToken2UserRedisDao.putAppUserAuthorization(user.getAccessToken(), user);
            request.setAttribute(Constants.REQUEST_ATTRIBUTE_AUTHORIZATION_USER, user);
            return true;
        }
    }

    //Web 记录最后操作时间，超过1小时，算过期
    private boolean handleWebAuthorization(HttpServletRequest request, HttpServletResponse response, UserAuthorization user) throws JsonProcessingException, IOException {
        // 更新最后操作时间
        long lastCallTime = user.getLastCallTime();
        long now = System.currentTimeMillis();
        if (now - lastCallTime > 1000 * 60 * 60 * 2) {
            // 2小时未操作则过期
            responseException(response, new ExceptionJsonObject(ResConstants.SYSTEM_TOKEN_EXPIRED.getCode(), ResConstants.SYSTEM_TOKEN_EXPIRED.getMsg()));
            return false;
        } else {
            user.setLastCallTime(System.currentTimeMillis());
            // 更新token的操作时间
            accessToken2UserRedisDao.putWebUserAuthorization(user.getAccessToken(), user);
            request.setAttribute(Constants.REQUEST_ATTRIBUTE_AUTHORIZATION_USER, user);
            return true;
        }
    }

    private void responseException(HttpServletResponse response, ExceptionJsonObject ejo) throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String exJson = objectMapper.writeValueAsString(ejo);

        response.setContentType(JSON_CONTENT_TYPE);
        response.setCharacterEncoding(Constants.COMMON_CHARSET_UTF8_NAME);
        response.getWriter().write(exJson);
    }*/

}
