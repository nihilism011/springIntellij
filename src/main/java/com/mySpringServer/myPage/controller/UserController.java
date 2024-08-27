package com.mySpringServer.myPage.controller;

import com.google.gson.Gson;
import com.mySpringServer.myPage.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")
    public String login(Model model) throws Exception {
        return "login";
    }
    @RequestMapping("/join.do")
    public String join(Model model) throws Exception {
        return "signUp";
    }


    @RequestMapping(value = "/login.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String signIn(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        System.out.println(map);
        resultMap = userService.loginService(map);
        return new Gson().toJson(resultMap);
    }
    @RequestMapping(value = "/signUp.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String signUp(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        System.out.println(map);
        resultMap = userService.signUpService(map);
        return new Gson().toJson(resultMap);
    }
    @RequestMapping(value = "/idCheck.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String idCheck(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = userService.userCheck(map);
        System.out.println(map);
        return new Gson().toJson(resultMap);
    }


}
