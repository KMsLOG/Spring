package com.ssafy.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        
        if (session.getAttribute("loggedInUser") == null) {
            response.setContentType("text/plain; charset=UTF-8"); // 텍스트 타입과 UTF-8 인코딩 설정
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            
            // 메시지 작성
            PrintWriter out = response.getWriter();
            out.write("로그인이 필요합니다."); // 단순 텍스트 메시지
            out.flush();
            return false; 
        }
        return true; 
    }
}
