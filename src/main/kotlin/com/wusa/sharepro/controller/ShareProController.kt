package com.wusa.sharepro.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@RequestMapping("/sharepro")
class ShareProController {

    @GetMapping("/hello")
    fun getHello(): String {
        return "Hello World"
    }

    @RequestMapping("/test")
    fun test(): String {
        return "html/listed"
    }
}