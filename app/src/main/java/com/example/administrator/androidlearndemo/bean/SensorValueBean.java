package com.example.administrator.androidlearndemo.bean;

/**
 * Created by Administrator on 2021/5/5 0005.
 */

public class SensorValueBean {
    private String index;
    private float value;

    public SensorValueBean(String index, float value) {
        this.index = index;
        this.value = value;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


}
