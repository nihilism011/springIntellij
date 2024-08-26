package com.mySpringServer.myPage.dao;

import com.mySpringServer.myPage.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public HashMap<String, Object> searchBoardList(HashMap<String,Object> map) {
        HashMap<String, Object> list = new HashMap<>();
        System.out.println(map);
        list.put("list", boardMapper.boardList(map));
        list.put("boardName","theBoard");
        return list;
    }

    @Override
    public HashMap<String, Object> removeBoardItem(HashMap<String, Object> map) {
        HashMap<String, Object> result = new HashMap<>();
        System.out.println(map);
        try{
            boardMapper.deleteBoardItem(map);
            result.put("msg","삭제 완료.");
        }catch (Exception e){
            result.put("msg","뭔가 뭔가 잘못됨.");
        }
        return result;
    }

    @Override
    public HashMap<String, Object> addBoardItem(HashMap<String, Object> map) {
        HashMap<String,Object> resultmap = new HashMap<>();
        System.out.println(map);
        try{
            boardMapper.insertBoardItem(map);
            resultmap.put("result","success");
            resultmap.put("msg","저장 완료.");
        }catch (Exception e){
            resultmap.put("result","fail");
            resultmap.put("msg","뭔가 뭔가 잘못됨.");
        }
        return resultmap;
    }
}
