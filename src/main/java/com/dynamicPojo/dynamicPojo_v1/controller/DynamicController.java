package com.dynamicPojo.dynamicPojo_v1.controller;


import com.dynamicPojo.dynamicPojo_v1.utils.DynamicPojoPostRequest;
import com.dynamicPojo.dynamicPojo_v1.utils.DynamicPojoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DynamicController {

    private static final Logger logger = LoggerFactory.getLogger(DynamicController.class);

    @PostMapping("/getClass")
    public DynamicPojoResponse getClass(@RequestBody  DynamicPojoPostRequest pojoPostRequest){

        logger.debug("Post Request body--"+pojoPostRequest);

        DynamicPojoResponse response=new DynamicPojoResponse();
        response.setResponseMesage("DATA RECIEVED.");
        return response;
    }

}
