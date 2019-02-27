package com.gnn.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 配置类
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     *添加http消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>>
                                                       converters) {

        converters.clear();

        //将java对象转换成json对象
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
