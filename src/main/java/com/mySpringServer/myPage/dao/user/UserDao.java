package com.mySpringServer.myPage.dao.user;

import com.mySpringServer.myPage.model.dto.ResponseDto;

import java.util.HashMap;

public interface UserDao {

    ResponseDto addUser(HashMap<String, Object> map);
    HashMap<String, Object> userLogin(HashMap<String, Object> map);
    HashMap<String, Object> userCheck(HashMap<String, Object> map);
    HashMap<String, Object> getUserList(HashMap<String, Object> map);
}
