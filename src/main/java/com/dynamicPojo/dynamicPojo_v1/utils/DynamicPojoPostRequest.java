package com.dynamicPojo.dynamicPojo_v1.utils;

import java.util.List;
import java.util.Objects;

public class DynamicPojoPostRequest {

    public String tableName;

    public List<ColumnesDetails> columnesDetails;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnesDetails> getColumnesDetails() {
        return columnesDetails;
    }

    public void setColumnesDetails(List<ColumnesDetails> columnesDetails) {
        this.columnesDetails = columnesDetails;
    }


    @Override
    public String toString() {
        return "DynamicPojoPostRequest{" +
                "tableName='" + tableName + '\'' +
                ", columnesDetails=" + columnesDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicPojoPostRequest that = (DynamicPojoPostRequest) o;
        return Objects.equals(tableName, that.tableName) && Objects.equals(columnesDetails, that.columnesDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, columnesDetails);
    }
}
