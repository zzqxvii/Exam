//package com.zzq.exam_stu_server.config;
//
//import com.zzq.exam_stu_server.filter.RequestFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean customFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new RequestFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("myFilter");
//        registration.setOrder(1);
//        return registration;
//    }
//}
