package com.leyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: soushihou
 * @Date: 2020/3/25
 * @Description: com.leyou.getway.config
 * @version: 1.0
 */
@Configuration
public class LeyouCorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {

        //初始化cors配置对象
        CorsConfiguration configuration = new CorsConfiguration();
        //允许跨域的域名，如果要携带cookie，不能写**：代表所有域名都可以跨域访问
        configuration.addAllowedOrigin("http://manage.leyou.com");
        configuration.setAllowCredentials(true);//允许携带cookie
        configuration.addAllowedMethod("*");//代表所有的请求方法：GET POST PUT Delete
        configuration.addAllowedHeader("*");

        //初始化corss配置源对象
        UrlBasedCorsConfigurationSource confiurationSource = new UrlBasedCorsConfigurationSource();
        confiurationSource.registerCorsConfiguration("/**", configuration);
        //返回corsFilter实例，参数：cors配置源对象
        return new CorsFilter(confiurationSource);
    }
}