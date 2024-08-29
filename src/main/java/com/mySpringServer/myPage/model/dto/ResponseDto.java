package com.mySpringServer.myPage.model.dto;


public class ResponseDto {
    private String message;
    private String status;

    public ResponseDto(String status,String message){
        this.status = status;
        this.message = message;
    }
}
