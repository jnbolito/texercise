package io.bolito.texercise.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class IndexController {

    @RequestMapping("/test/{title}")
    fun index(model: Model, @RequestParam("mytext") text: String, @PathVariable("title") title: String): String {
        model["title"] = title
        model.addAttribute("mytext", text)
        return "views/welcome"
    }
}