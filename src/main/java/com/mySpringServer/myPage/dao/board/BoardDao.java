package com.mySpringServer.myPage.dao.board;

import java.util.HashMap;

public interface BoardDao {
    HashMap<String,Object> searchBoardList(HashMap<String,Object> map);
    HashMap<String,Object> removeBoardItem(HashMap<String,Object> map);
    HashMap<String,Object> addBoardItem(HashMap<String,Object> map);
    HashMap<String,Object> getBoardItem(HashMap<String,Object> map);
}
