package com.leo.ssm.exception;

import com.leo.ssm.exception.custom.BusinessException;
import com.leo.ssm.exception.custom.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常统⼀处理
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView("exception/error");
        mv.addObject("ex", "默认错误信息");
        // 判断是否是⾃定义异常
        if (ex instanceof ParamsException) {
            mv.setViewName("exception/params_error");
            ParamsException e = (ParamsException) ex;
            mv.addObject("ex", e.getMsg());
        }
        if (ex instanceof BusinessException) {
            mv.setViewName("exception/business_error");
            BusinessException e = (BusinessException) ex;
            mv.addObject("ex", e.getMsg());
        }
        return mv;
    }
}