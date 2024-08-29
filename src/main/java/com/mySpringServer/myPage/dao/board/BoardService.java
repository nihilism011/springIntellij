package com.mySpringServer.myPage.dao.board;

import com.mySpringServer.myPage.mapper.BoardMapper;
import com.mySpringServer.myPage.model.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BoardService implements BoardDao {

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

    @Override
    public HashMap<String, Object> getBoardItem(HashMap<String, Object> map) {
        HashMap<String, Object> result = new HashMap<>();
        try{
            Board selectBoard= boardMapper.selectBoardItem(map);
            if(selectBoard != null){
                result.put("result","success");
                result.put("board",selectBoard);
            }else{
                result.put("result","removed");
                result.put("msg","없는 게시글 입니다.");
            }
        }catch (Exception e){
                result.put("result","fail");
                result.put("msg","데이터베이스 오류");
        }
        return result;
    }
}
