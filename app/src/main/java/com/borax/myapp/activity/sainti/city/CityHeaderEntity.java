package com.borax.myapp.activity.sainti.city;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BoraxZYF on 2017/5/27.
 */

public class CityHeaderEntity {

    private List<CityEntity> list = new ArrayList<CityEntity>();

    public CityHeaderEntity(List<CityEntity> list) {
        this.list = list;
    }

    public List<CityEntity> getList() {
        return list;
    }

    public void setList(List<CityEntity> list) {
        this.list = list;
    }
}
