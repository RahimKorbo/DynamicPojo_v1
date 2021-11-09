package com.dynamicPojo.dynamicPojo_v1.utils;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DynamicPojoPostValidator implements Validator {

    private final MessageSource messageSource;


    @Override
    public boolean supports(Class<?> clazz) {
        return DynamicPojoPostRequest.class.isAssignableFrom(clazz);
    }

    public DynamicPojoPostValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DynamicPojoPostRequest request = (DynamicPojoPostRequest)target;
        validatePostRequest(request, errors,messageSource);
    }

    private void validatePostRequest(DynamicPojoPostRequest request, Errors errors,MessageSource messageSource) {
        if(request.tableName == null && request.getColumnesDetails() == null) {
            String rejectField  = request.tableName == null ? "Table Name": "Column Details";
            errors.rejectValue(rejectField, "RequireCorrelation",(Object[])null,messageSource.getMessage("w.common.validation.require-correlation",new String[]{"TableName","ColumnDetails"}, LocaleContextHolder.getLocale()));
        }
    }
}
