package com.mySpringServer.myPage.mapper;

import com.mySpringServer.myPage.model.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> boardList(HashMap<String,Object> map);
    void deleteBoardItem(HashMap<String,Object> map);
    void insertBoardItem(HashMap<String,Object> map);
    Board selectBoardItem(HashMap<String,Object> map);
}
