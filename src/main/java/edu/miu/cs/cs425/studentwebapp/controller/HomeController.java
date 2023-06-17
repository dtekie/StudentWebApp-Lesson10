package edu.miu.cs.cs425.studentwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/"})
    public String displayHomepage() {
        return "home/index";
    }

    @GetMapping(value = {"/about"})
    public String displayAboutPage() {
        return "home/about";
    }

}
