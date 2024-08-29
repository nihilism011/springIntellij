package com.mySpringServer.myPage.dao.user;

import com.mySpringServer.myPage.common.ResultMessage;
import com.mySpringServer.myPage.common.ResultStatus;
import com.mySpringServer.myPage.mapper.UserMapper;
import com.mySpringServer.myPage.model.dto.ResponseDto;
import com.mySpringServer.myPage.model.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService implements UserDao {

    @Autowired
    UserMapper userMapper;

    @Autowired
    HttpSession session;

    @Override
    public ResponseDto addUser(HashMap<String, Object> map) {
        ResponseDto response;
        try {
            if(userMapper.insertUser(map) > 0) {
                response = new ResponseDto(ResultStatus.SUCCESS, ResultMessage.INSERT);
            }else{
                response = new ResponseDto((ResultStatus.FAIL),ResultMessage.FAIL);
            }
        } catch (Exception e) {
            response = new ResponseDto(ResultStatus.ERROR, ResultMessage.ERROR);
        }
        return response;
    }

    @Override
    public HashMap<String, Object> userLogin(HashMap<String, Object> map) {
        HashMap<String, Object> result = new HashMap<>();
        ResponseDto responseDto;
        try {
            User idChecker = userMapper.userCheck(map);
            if(idChecker == null){
                responseDto = new ResponseDto("fail","아이디를 확인해주세요.");
            }else{
                User loginUser = userMapper.userLogin(map);
                if(loginUser != null) {
                    responseDto = new ResponseDto("success","환영합니다.");
                    session.setAttribute("userId",loginUser.getUserId());
                }else{
                    responseDto = new ResponseDto("fail","비밀번호를 확인해주세요.");
                }
            }
        } catch (Exception e){
            responseDto = new ResponseDto("error","DB 오류");
        }
        result.put("result",responseDto);
        return result;
    }

    @Override
    public HashMap<String, Object> userCheck(HashMap<String, Object> map) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            User user = userMapper.userCheck(map);
            result.put("result", "success");
            if (user == null) {
                result.put("check", "none");
                result.put("msg", "사용 가능한 아이디 입니다.");
            }else {
                result.put("check", "one");
                result.put("msg", "이미 사용중인 아이디 입니다.");
            }
        }catch (Exception e){
            result.put("result","fail");
        }
        return result;
    }

    @Override
    public HashMap<String, Object> getUserList(HashMap<String, Object> map) {
        HashMap<String, Object> result = new HashMap<>();
        System.out.println(map);
        try {
            List<User> userList = userMapper.searchUserList(map);
            result.put("userList",userList);
            result.put("result",ResultStatus.SUCCESS);
        }catch (Exception e){
            result.put("result",ResultStatus.ERROR);
            result.put("msg",ResultMessage.ERROR);
        }

        return result;
    }
}
