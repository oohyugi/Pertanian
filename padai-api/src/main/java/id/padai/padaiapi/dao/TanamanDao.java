package id.padai.padaiapi.dao;

import java.io.Serializable;

/**
 * Created by yogi on 09/06/16.
 */
public class TanamanDao implements Serializable {

    String id;
    String nama;
    String detail;
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
