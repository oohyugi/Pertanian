package id.padai.padaiapi.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yogi on 08/06/16.
 */
public class LOGIN {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("usernae")
    @Expose
    private String usernae;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The usernae
     */
    public String getUsernae() {
        return usernae;
    }

    /**
     *
     * @param usernae
     * The usernae
     */
    public void setUsernae(String usernae) {
        this.usernae = usernae;
    }
}
