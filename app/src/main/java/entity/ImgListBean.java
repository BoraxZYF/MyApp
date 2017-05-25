package entity;

import java.io.Serializable;

/**
 * Created by borax on 2017/3/16.
 */
public class ImgListBean implements Serializable {
    private String img_url;
    private String img_url_thumbnail;
    private String file_id;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getImg_url_thumbnail() {
        return img_url_thumbnail;
    }

    public void setImg_url_thumbnail(String img_url_thumbnail) {
        this.img_url_thumbnail = img_url_thumbnail;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }
}