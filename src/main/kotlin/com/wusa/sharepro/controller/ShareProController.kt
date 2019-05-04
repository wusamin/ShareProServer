package com.wusa.sharepro.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sharepro")
class ShareProController {

    @GetMapping("/hello")
    fun getHello(): String {
        return "Hello World"
    }
}