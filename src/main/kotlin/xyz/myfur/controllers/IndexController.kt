package xyz.myfur.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class IndexController {
    @GetMapping(value = ["**"])
    fun index(m: Model): String {
        m.addAttribute("title","World")
        return "index"
    }
    @PostMapping(value = ["**"])
    fun fuck(request: HttpServletRequest,responce:HttpServletResponse){
        println(request.requestURL)
    }
}