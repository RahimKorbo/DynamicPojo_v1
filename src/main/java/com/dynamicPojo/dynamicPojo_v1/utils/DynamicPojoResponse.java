package com.dynamicPojo.dynamicPojo_v1.utils;

import java.util.Objects;

public class DynamicPojoResponse {

    private String responseMesage;

    public DynamicPojoResponse() {
    }

    public String getResponseMesage() {
        return responseMesage;
    }

    public void setResponseMesage(String responseMesage) {
        this.responseMesage = responseMesage;
    }


    @Override
    public String toString() {
        return "DynamicPojoResponse{" +
                "responseMesage='" + responseMesage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicPojoResponse that = (DynamicPojoResponse) o;
        return Objects.equals(responseMesage, that.responseMesage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseMesage);
    }
}
