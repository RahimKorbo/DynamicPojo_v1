package com.dynamicPojo.dynamicPojo_v1.service.impl;

import com.dynamicPojo.dynamicPojo_v1.service.BusinessLogic;
import com.dynamicPojo.dynamicPojo_v1.utils.Constants;
import com.dynamicPojo.dynamicPojo_v1.utils.DynamicPojoPostRequest;

import java.util.HashMap;
import java.util.Set;

public class BusinessLogicImpl implements BusinessLogic {

    @Override
    public String getClassLogic(DynamicPojoPostRequest request) {
        String tableName="Persons";

        HashMap<String,String> columnMap=new HashMap<String,String>();
        columnMap.put("PersonsId","varchar");
        columnMap.put("age","int");

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

//        System.out.println(hset);

        for(String s:hset){

            if(columnMap.get(s) == Constants.INT){
                skeletonString+=Constants.DATATYPE_INT+s+Constants.NEWLINE_IV;
            }else if(columnMap.get(s) == Constants.VARCHAR){
                skeletonString+=Constants.DATATYPE_STRING+s+Constants.NEWLINE_IV;
            }


        }

        skeletonString+=Constants.CLOSINGBRACES;

        System.out.println(skeletonString);


        return null;

    }
}
