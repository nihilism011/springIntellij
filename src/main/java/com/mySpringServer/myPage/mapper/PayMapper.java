package com.mySpringServer.myPage.mapper;

import com.mySpringServer.myPage.model.Pay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper {
    List<Pay> payList();

}
