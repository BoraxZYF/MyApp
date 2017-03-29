package entity;

/**
 * Created by borax on 2016/10/28.
 */

public class UserBean {


    /**
     * result : 1
     * msg :
     * data : {"user_id":"145","user_nickname":"18841148357","user_avatar":"http://o7t9la85i.bkt.clouddn.com/upload/2016-06/30/14672661487627.jpg","user_about":"123"}
     */

    private String result;
    private String msg;
    /**
     * user_id : 145
     * user_nickname : 18841148357
     * user_avatar : http://o7t9la85i.bkt.clouddn.com/upload/2016-06/30/14672661487627.jpg
     * user_about : 123
     */

    private DataBean data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String user_id;
        private String user_nickname;
        private String user_avatar;
        private String user_about;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_nickname() {
            return user_nickname;
        }

        public void setUser_nickname(String user_nickname) {
            this.user_nickname = user_nickname;
        }

        public String getUser_avatar() {
            return user_avatar;
        }

        public void setUser_avatar(String user_avatar) {
            this.user_avatar = user_avatar;
        }

        public String getUser_about() {
            return user_about;
        }

        public void setUser_about(String user_about) {
            this.user_about = user_about;
        }
    }
}
