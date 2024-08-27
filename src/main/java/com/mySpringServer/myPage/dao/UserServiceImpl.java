package com.mySpringServer.myPage.dao;

import com.mySpringServer.myPage.mapper.UserMapper;
import com.mySpringServer.myPage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public HashMap<String, Object> signUpService(HashMap<String, Object> map) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            userMapper.signUp(map);
            result.put("msg","회원 가입이 완료 되었습니다.");
            result.put("result","success");
        } catch (Exception e) {
            result.put("msg","뭔가 뭔가 오류남 회원가입이...");
            result.put("result","fail");
        }
        return null;
    }

    @Override
    public HashMap<String, Object> loginService(HashMap<String, Object> map) {
        HashMap<String, Object> result = new HashMap<>();
        User loginUser;
        try {
            loginUser = userMapper.signIn(map);
            if(loginUser == null) {
                result.put("msg", "환영합니다.");
                result.put("result", "success");
            }
        } catch (Exception e){
            result.put("msg","뭔가 뭔가 오류남 로그인이...");
            result.put("result","fail");
        }
        return null;
    }
}
