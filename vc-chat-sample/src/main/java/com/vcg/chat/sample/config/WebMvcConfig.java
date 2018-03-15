package com.vcg.chat.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

/**
 * Created by wuyu on 2017/4/4.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    private static final String TEMP_DIR = System.getProperty("java.io.tmpdir");

    /**
     * 临时文件夹 ，用于测试
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/storage/**").addResourceLocations(new File(TEMP_DIR).toURI().toString());
    }
}
