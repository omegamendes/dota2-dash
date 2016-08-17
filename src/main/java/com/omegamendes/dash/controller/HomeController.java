package com.omegamendes.dash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mame on 17/08/2016.
 */
@Controller
public class HomeController {

    @RequestMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "name");
        return "greeting";
    }
}
