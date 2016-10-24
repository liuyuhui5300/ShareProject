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
package com.manager.framework.aop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.manager.framework.exception.ManagerRuntimeException;
import com.manager.framework.log.LOG_TYPE;
import com.manager.framework.utils.encoding.Json;

/**
 * <br>创建日期：2016年10月24日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
@Aspect
public class ControllerAspect {

	private final Logger logger = LoggerFactory.getLogger(LOG_TYPE.CONTROLLER_ASPECT.val);

    /**
     * Controller aspect.
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerAspect() {
    }

    /**
     * Around
     * 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
     *
     * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice
     * 执行完AfterAdvice，再转到ThrowingAdvice
     * @param pjp the pjp
     * @return object
     * @throws Throwable the throwable
     */
    @Around(value = "controllerAspect()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        //1.入参打印
        printInLog(pjp);
        long startTime = System.currentTimeMillis();
        try {
            Object response = pjp.proceed();
            //2.打印出参，返回结果
            long endTime = System.currentTimeMillis();
            //3.出参打印
            printOutLog(pjp, endTime - startTime, response);
            return response;
        } catch (Throwable e) {
            long endTime = System.currentTimeMillis();
            printOutLog(pjp, endTime - startTime, e instanceof ManagerRuntimeException ? "业务异常" : "系统异常", e);
            throw e;
        }

    }

    private void printInLog(ProceedingJoinPoint pjp) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String className = pjp.getSignature().getDeclaringTypeName();
        Map<String, Object> requestMap = new LinkedHashMap<String, Object>();

        requestMap.put("className", className);

        if (pjp.getArgs().length > 0) {
            List<String> methodParams = new ArrayList<String>();
            for (Object o : pjp.getArgs()) {
                methodParams.add(ToStringBuilder.reflectionToString(o, ToStringStyle.SHORT_PREFIX_STYLE));
            }
            requestMap.put("message", methodParams);
        }
        logger.info(Json.ToJson(requestMap));

    }

    private void printOutLog(ProceedingJoinPoint pjp, long timeCost, Object response) {
        logger.info(reponseMessage(pjp, timeCost, response));
    }

    private void printOutLog(ProceedingJoinPoint pjp, long timeCost, Object response, Throwable e) {
        if (e instanceof ManagerRuntimeException) {
            logger.warn(reponseMessage(pjp, timeCost, response), e);
        } else {
            logger.error(reponseMessage(pjp, timeCost, response), e);
        }

    }

    private String reponseMessage(ProceedingJoinPoint pjp, long timeCost, Object response) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String className = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
        responseMap.put("className", className);
        if (response != null) {
            responseMap.put("message", response instanceof String ? response : ToStringBuilder.reflectionToString(response, ToStringStyle.SHORT_PREFIX_STYLE));
        }
        return Json.ToJson(responseMap);
    }
}
