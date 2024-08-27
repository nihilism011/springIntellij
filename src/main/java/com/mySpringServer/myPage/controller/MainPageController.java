package com.mySpringServer.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @RequestMapping("/")
    public String boardList(Model model) throws Exception {
        return "index";
    }
}
