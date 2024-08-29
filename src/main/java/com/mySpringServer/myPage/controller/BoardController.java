package com.mySpringServer.myPage.controller;

import com.google.gson.Gson;
import com.mySpringServer.myPage.dao.board.BoardDao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class BoardController {

    @Autowired
    BoardDao boardservice;

    @RequestMapping("/board-list.do")
    public String boardList(Model model) throws Exception {
        return "/board-list.html";
    }
    @RequestMapping("/board-login.do")
    public String aaaa(Model model) throws Exception {
        return "/board-login.html";
    }
    @RequestMapping("/testthyme.do")
    public String thyme(Model model) throws Exception {
        // 모델에 데이터 추가가 필요한 경우 추가
        return "hello";  // "hello" 템플릿을 렌더링합니다.
    }


    @RequestMapping("/board-insert.do")
    public String boardInsert(Model model) throws Exception {
        return "/board-insert.html";
    }
    @PostMapping("/board-view.do")
    public String boardView(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
        model.addAttribute("initialData",map);
        return "board-view";
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
