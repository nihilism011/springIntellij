package com.mySpringServer.myPage.model.entity;

import lombok.Data;

@Data
public class Board {
    private int boardNo;
    private String title;
    private String contents;
    private String userId;
    private int hit;
    private int category;
    private int favorite;
    private String tag1;
    private String tag2;
    private String noticeYn;
    private String cDateTime;
    private String uDateTime;
    private String userName;


}
