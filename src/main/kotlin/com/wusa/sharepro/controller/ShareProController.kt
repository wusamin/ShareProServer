package com.wusa.sharepro.controller

import com.wusa.sharepro.data.uploadForm
import com.wusa.sharepro.service.ShareProService
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView

@Controller
@ComponentScan("service")
@RequestMapping("/sharepro")
class ShareProController(private val service: ShareProService) {


    @RequestMapping("/list")
    fun viewList(mav: ModelAndView): ModelAndView {
        mav.addObject("pictures", service.findAllPicture())
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
        service.uploadPicture(form, file)
        return "html/upload"
    }
}