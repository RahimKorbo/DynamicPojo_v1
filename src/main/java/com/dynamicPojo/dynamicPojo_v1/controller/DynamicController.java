package com.dynamicPojo.dynamicPojo_v1.controller;


import com.dynamicPojo.dynamicPojo_v1.service.BusinessLogic;
import com.dynamicPojo.dynamicPojo_v1.utils.DynamicPojoPostRequest;
import com.dynamicPojo.dynamicPojo_v1.utils.DynamicPojoPostValidator;
import com.dynamicPojo.dynamicPojo_v1.utils.DynamicPojoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DynamicController {

    private static final Logger logger = LoggerFactory.getLogger(DynamicController.class);

    private DynamicPojoPostValidator dynamicPojoPostValidator;

    @Autowired
    private BusinessLogic bussinessLogic;

    public DynamicController(DynamicPojoPostValidator dynamicPojoPostValidator) {
        this.dynamicPojoPostValidator = dynamicPojoPostValidator;

    }

    @InitBinder("dynamicPojoPostRequest")
    public void initBinderPost(WebDataBinder binder) {
        binder.addValidators(dynamicPojoPostValidator);
    }

    @PostMapping("/getClass")
    public DynamicPojoResponse getClass(@RequestBody  DynamicPojoPostRequest pojoPostRequest){

        logger.debug("Post Request body--"+pojoPostRequest);
        DynamicPojoResponse response=new DynamicPojoResponse();
        String businessResponse = bussinessLogic.getClassLogic(pojoPostRequest);
        logger.debug("Business Response ="+businessResponse);
        response.setResponseMesage(businessResponse);
        return response;
    }

}
