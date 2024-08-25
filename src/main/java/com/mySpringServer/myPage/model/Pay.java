package com.mySpringServer.myPage.model;


import lombok.Data;

@Data
public class Pay {
    private int id;
    private String name;
    private int price;
    private int month;
    private int isClear;

}
