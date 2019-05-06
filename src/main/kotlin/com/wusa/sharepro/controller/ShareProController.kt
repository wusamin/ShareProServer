package com.wusa.sharepro.controller

import com.wusa.sharepro.data.uploadForm
import com.wusa.sharepro.service.ShareProService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView

@Controller
@ComponentScan("service")
@RequestMapping("/sharepro")
class ShareProController {

    @Autowired
    lateinit var service: ShareProService

    @GetMapping("/hello")
    fun getHello(): String {
        return "Hello World"
    }

    @RequestMapping("/test")
    fun test(@RequestParam("upload_file") file: MultipartFile): String {
        println(file.name)
        println(file.contentType)
        return "html/upload"
    }

    @RequestMapping("/list")
    fun viewList(mav: ModelAndView): ModelAndView {

        mav.addObject("pictures", service.getAllPicture())
        mav.viewName = "html/listed"
        return mav
    }

    @RequestMapping("/uploadform")
    fun moveUpload(): String {
        return "html/upload"
    }

    @PostMapping("/upload")
    fun uploadPicture(model: Model, @ModelAttribute("uploadForm") form:
    uploadForm, @RequestParam("uploadFile") file: MultipartFile): String {
        println(form.contributor)
        println(form.fileName)
        println(form.location)
        println(form.uploadDay)
        println(file.contentType)
        service.uploadPicture(form, file)
        return "html/upload"
    }
}