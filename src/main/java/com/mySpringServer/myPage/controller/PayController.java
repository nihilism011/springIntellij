package com.mySpringServer.myPage.controller;

import com.google.gson.Gson;
import com.mySpringServer.myPage.dao.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class PayController {
    @Autowired
    PayService payService;

    @RequestMapping("/")
    public String main(Model model) throws Exception{

        return "/index.html";
    }

    @RequestMapping(value = "/payList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String searchBbsList(Model model) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = payService.searchPayList();
        return new Gson().toJson(resultMap);
    }

}
