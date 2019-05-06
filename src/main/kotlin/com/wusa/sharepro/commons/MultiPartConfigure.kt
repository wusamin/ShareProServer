package com.wusa.sharepro.commons

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.multipart.MultipartResolver
import org.springframework.web.multipart.support.StandardServletMultipartResolver


@Configuration
class MultiPartConfigure {

    @Bean
    fun multipartResolver(): MultipartResolver {
        return StandardServletMultipartResolver()
    }
}