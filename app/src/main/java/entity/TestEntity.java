package entity;

/**
 * Created by zhaoyuefeng on 2017/8/30.
 */

public class TestEntity {

    private long appUserid;
    private String token;

    public TestEntity(long appUserid, String token) {
        this.appUserid = appUserid;
        this.token = token;
    }

    public long getAppUserid() {
        return appUserid;
    }

    public void setAppUserid(long appUserid) {
        this.appUserid = appUserid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
