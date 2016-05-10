/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.common;

import java.util.List;

/**
 *
 * @author KittyG
 */
public class DataRow {

    private boolean valid;
    private List<String> dataList;

    public DataRow(List<String> dataList) {
        this.dataList = dataList;
    }

    public DataRow(List<String> dataList, boolean valid) {
        this.dataList = dataList;
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<String> getDataList() {
        return dataList;
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }

}
