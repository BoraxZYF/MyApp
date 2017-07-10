package entity;

import java.util.List;

/**
 * Created by BoraxZYF on 2017/6/19.
 */

public class LongServiceTestBean {


    /**
     * result : 0
     * msg : 0
     * data : []
     */

    private int result;
    private int msg;
    private List<?> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
