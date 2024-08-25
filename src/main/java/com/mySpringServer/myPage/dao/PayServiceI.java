package com.mySpringServer.myPage.dao;

import com.mySpringServer.myPage.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PayServiceI implements PayService{

    @Autowired
    PayMapper payMapper;

    @Override
    public HashMap<String, Object> searchPayList() {
        HashMap<String, Object> ki = new HashMap<>();
        ki.put("list",payMapper.payList());
        return ki;
    }
}
