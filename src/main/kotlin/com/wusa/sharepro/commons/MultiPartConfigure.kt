package com.wusa.sharepro.commons

import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.multipart.MultipartResolver
import org.springframework.web.multipart.support.StandardServletMultipartResolver
import javax.servlet.MultipartConfigElement


@Configuration
class MultiPartConfigure {

    @Bean
    fun multipartResolver(): MultipartResolver {
        return StandardServletMultipartResolver()
    }

    @Bean
    fun multipartConfigElement(): MultipartConfigElement {
        val factory = MultipartConfigFactory()
        factory.setMaxFileSize("100MB")
        factory.setMaxRequestSize("100MB")
        return factory.createMultipartConfig()
    }
}