package com.borax.myapp.activity.sainti.waterfall;

/**
 * Created by BoraxZYF on 2017/6/12.
 */

public class PicBean {

    private int pic;
    private String name;

    public PicBean(int pic, String name) {
        this.pic = pic;
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
