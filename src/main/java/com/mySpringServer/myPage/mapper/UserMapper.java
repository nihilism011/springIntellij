package com.mySpringServer.myPage.mapper;

import com.mySpringServer.myPage.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {

    List<User> searchUserList(HashMap<String,Object> map);
    void signUp(HashMap<String, Object> map);
    User userLogin(HashMap<String, Object> map);
    User userCheck(HashMap<String, Object> map);
    int insertUser(HashMap<String,Object> map);
}
