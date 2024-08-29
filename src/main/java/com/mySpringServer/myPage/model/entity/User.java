package com.mySpringServer.myPage.model.entity;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String password;
    private String userName;
    private String email;
    private String phone;
    private String gender;
    private String nickName;
}
