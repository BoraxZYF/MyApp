package com.borax.myapp.activity.sainti.spinner.entity;

/**
 * Created by BoraxZYF on 2017/6/13.
 */

public class MenuCellBean {

    private int type;
    private String name;

    public MenuCellBean(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
