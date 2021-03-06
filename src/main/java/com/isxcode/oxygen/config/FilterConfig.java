//package com.isxcode.ispring.config;
//
//import com.isxcode.ispring.filter.JwtFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//
///**
// * 拦截器配置
// *
// * @author ispong
// * @version v0.1.0
// * @date 2019-11-16
// */
//@Configuration
//public class FilterConfig {
//
//    /**
//     * JWT 拦截器配置
//     *
//     * @since 2019-11-16
//     */
//    @Bean
//    public FilterRegistrationBean jwtFilterBean() {
//
//        FilterRegistrationBean<JwtFilter> jwtFilterBean = new FilterRegistrationBean<>();
//        jwtFilterBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 9);
//        String[] excludeUrlPatterns = {
//                "/userAuth",
//        };
//        JwtFilter jwtFilter = new JwtFilter();
//        jwtFilter.addExcludeUrlPatterns(excludeUrlPatterns);
//        jwtFilterBean.setFilter(jwtFilter);
//        return jwtFilterBean;
//    }
//
//}
