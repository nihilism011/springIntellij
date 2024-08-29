package com.mySpringServer.myPage.controller;

import com.google.gson.Gson;
import com.mySpringServer.myPage.dao.user.UserDao;
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
    UserDao userDao;

    @RequestMapping("/login.do")
    public String login(Model model) throws Exception {
        return "login";
    }
    @RequestMapping("/join.do")
    public String join(Model model) throws Exception {
        return "signUp";
    }
    @RequestMapping("/user-list.do")
    public String userList(Model model) throws Exception {
        return "user-list";
    }


// 로그인
    @RequestMapping(value = "/login.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String signIn(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        System.out.println(map);
        resultMap = userDao.userLogin(map);
        return new Gson().toJson(resultMap);
    }
//    회원가입
    @RequestMapping(value = "/insertUser.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String insertUser(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        return new Gson().toJson(userDao.addUser(map));
    }
    @RequestMapping(value = "/idCheck.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String idCheck(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = userDao.userCheck(map);
        System.out.println(map);
        return new Gson().toJson(resultMap);
    }
    @RequestMapping(value = "/getUserList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getUserList(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        return new Gson().toJson(userDao.getUserList(map));
    }



}
