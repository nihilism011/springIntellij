package com.mySpringServer.myPage.dao;

import java.util.HashMap;

public interface UserService {

    HashMap<String, Object> signUpService(HashMap<String, Object> map);
    HashMap<String, Object> loginService(HashMap<String, Object> map);
}
