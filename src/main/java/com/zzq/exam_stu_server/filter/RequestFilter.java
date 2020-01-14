//package com.zzq.exam_stu_server.filter;
//
//import com.zzq.exam_stu_server.domain.dao.UserMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@Slf4j
//public class RequestFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        HttpSession session = request.getSession(true);
//
//        log.info("Filter sessionId[{}]",session.getId());
//        if ( request.getRequestURI().equals("/login") ){
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//
//            log.info("-->用户名[{}],密码[{}] 尝试登录",username,password);
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else if(session.getAttribute("username") == null){
//
//            log.info("非法请求 session[{}][{}]",session.getAttribute("username"),session.getId());
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
