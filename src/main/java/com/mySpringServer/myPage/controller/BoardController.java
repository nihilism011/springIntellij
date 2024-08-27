package com.mySpringServer.myPage.controller;

import com.google.gson.Gson;
import com.mySpringServer.myPage.dao.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class BoardController {

    @Autowired
    BoardService boardservice;

    @RequestMapping("/board-list.do")
    public String boardList(Model model) throws Exception {
        return "/board-list.html";
    }

    @RequestMapping("/board-insert.do")
    public String boardInsert(Model model) throws Exception {
        return "/board-insert.html";
    }

    @RequestMapping("/board-view.do")
    public String boardView(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
        System.out.println(map);
        return "/board-view.html";
    }

    @RequestMapping(value = "/board-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String searchList(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = boardservice.searchBoardList(map);
        return new Gson().toJson(resultMap);
    }

    @RequestMapping(value = "/board-delete.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteList(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = boardservice.removeBoardItem(map);
        return new Gson().toJson(resultMap);
    }

    @RequestMapping(value = "/board-add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addBoard(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = boardservice.addBoardItem(map);
        return new Gson().toJson(resultMap);
    }
    @RequestMapping(value = "/board-view.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String viewBoard(Model model, @RequestBody HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap = boardservice.getBoardItem(map);
        return new Gson().toJson(resultMap);
    }
}
