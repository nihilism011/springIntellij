package com.mySpringServer.myPage.dao;

import java.util.HashMap;

public interface BoardService {
    HashMap<String,Object> searchBoardList(HashMap<String,Object> map);
    HashMap<String,Object> removeBoardItem(HashMap<String,Object> map);
    HashMap<String,Object> addBoardItem(HashMap<String,Object> map);
}
