package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/teste")
    public String teste() {
        return "admin/index";
    }
}
