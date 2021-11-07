package com.dynamicPojo.dynamicPojo_v1.controller;


import com.dynamicPojo.dynamicPojo_v1.utils.DynamicPojoPostRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class dynamicController {


    @PostMapping("/getClass")
    public String getClass(DynamicPojoPostRequest pojoPostRequest){

        return null;
    }

}
