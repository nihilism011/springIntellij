package com.mySpringServer.myPage.mapper;

import com.mySpringServer.myPage.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface UserMapper {

    void signUp(HashMap<String, Object> map);
    User signIn(HashMap<String, Object> map);
}
