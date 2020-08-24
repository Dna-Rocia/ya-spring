package com.ya.spring.mvc.controller.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Description 处理控制器建言
 *  注解：ExceptionHandler，ModelAttribute，InitBinder 对所有注解了@RequestMapping的控制器内的方法有效
 * @Author ROCIA
 * @Date 2020/8/24
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 捕获全局异常
     * @param e 异常
     * @param request 请求
     * @return 渲染后视图
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception e, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errMsg",e.getMessage());
        return modelAndView;
    }

    /**
     * set 全局参数
     * 将当前键值对添加到全局，所有的@requestMapping()都可以获取到该键值对
     * @param model spring-context里特有的Model类
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    /**
     *  在平时使用SpringMVC时，会碰到javabean中有Date类型参数，表单中传来代表日期的字符串转化为日期类型，SpringMVC默认不支持这种类型的转换。
     * 我们就需要手动设置时间格式并在webDateBinder上注册这个编辑器！
     * @param webDataBinder  用来绑定请求参数到指定的属性编辑器
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id"); //setDisallowedFields设置忽略参数
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true);
        webDataBinder.registerCustomEditor(Date.class, editor);//registerCustomEditor 自己注册一个编辑器
    }

}
