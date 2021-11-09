package com.dynamicPojo.dynamicPojo_v1.service.impl;

import com.dynamicPojo.dynamicPojo_v1.controller.DynamicController;
import com.dynamicPojo.dynamicPojo_v1.service.BusinessLogic;
import com.dynamicPojo.dynamicPojo_v1.utils.ColumnesDetails;
import com.dynamicPojo.dynamicPojo_v1.utils.Constants;
import com.dynamicPojo.dynamicPojo_v1.utils.DynamicPojoPostRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class BusinessLogicImpl implements BusinessLogic {


    private static final Logger logger = LoggerFactory.getLogger(BusinessLogicImpl.class);


    @Override
    public String getClassLogic(DynamicPojoPostRequest request) {
        String tableName= request.getTableName();

        logger.debug("Business Serviewss---"+String.valueOf(request));
        HashMap<String,String> columnMap=new HashMap<String,String>();

        List<ColumnesDetails> list = request.getColumnesDetails();

        logger.debug("List taken from reqeust--> "+list);

        for(ColumnesDetails col:list){

            columnMap.put(col.getColumnName(),col.getColumnType());
        }
        logger.debug("columnMap --"+columnMap);
        //columnMap.put("PersonsId","varchar");
        //columnMap.put("age","int");

        /*public class Persons{

            public int PersonsId;
            public String lastName;
            public String firstName;
            public String address;
            public String city;

            getters and setters is not mandatory becuase many IDE's providing functionality to automate like lombak or generate setter or getter
            same is not for IV

        }*/

        String skeletonString="";

        skeletonString+= Constants.CLASSNAME +tableName+Constants.OPENBRACES;




        Set<String> hset=columnMap.keySet();

       //System.out.println(hset);

        for(String s:hset){

            if(columnMap.get(s).equals(Constants.INT)){
                skeletonString+=Constants.DATATYPE_INT+s+Constants.NEWLINE_IV;

                // logger.debug("Inside First IF");
            }else if(columnMap.get(s).equals(Constants.VARCHAR)){
                skeletonString+=Constants.DATATYPE_STRING+s+Constants.NEWLINE_IV;

               // logger.debug("Inside Second IF");
            }


        }
        //public class Persons { \n\t public int PersonsId;  \n\t public String FirstName;  \n}

        skeletonString+=Constants.CLOSINGBRACES;

       // System.out.println(skeletonString);


        return skeletonString;

    }
}
