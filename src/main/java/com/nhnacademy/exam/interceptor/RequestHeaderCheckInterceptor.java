package com.nhnacademy.exam.interceptor;

import com.nhnacademy.exam.exception.NotSupportAcceptException;
import com.nhnacademy.exam.exception.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class RequestHeaderCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // Accept: 에 지원하지않는 csv 타입
        String accept = request.getHeader("Accept");
        if(accept == null || accept.contains("csv")) {
            throw new NotSupportAcceptException();
        }

        // X-USER-ID가 nhnacademy 인지 검사
        String xUserHeader = request.getHeader("X-USER-ID");
        if(xUserHeader == null || xUserHeader.isBlank() || !xUserHeader.equals("nhnacademy")) {
            throw new UnauthorizedException();
        }


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
