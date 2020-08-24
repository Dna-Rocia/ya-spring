package com.ya.spring.mvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 自定义拦截器
 * @Author ROCIA
 * @Date 2020/8/24
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {


    /**
     * 在请求执行前执行
     * @param request 请求
     * @param response 响应
     * @param handler 操作对象
     * @return 是否可继续执行该请求。 true-可以通过； false-非法请求，驳回请求
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    /**
     * 在请求执行后执行
     * @param request 请求
     * @param response 响应
     * @param handler 操作对象
     * @param modelAndView 渲染后视图
     * @throws Exception 执行期间抛出异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求耗时："+ (endTime - startTime) + "ms");
        request.setAttribute("handleTime",endTime - startTime);
    }


}
