package id.padai.padaiapi.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yogi on 03/06/16.
 */
public class LoginDao {
    @SerializedName("login")
    @Expose
    private int login;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;

    /**
     *
     * @return
     * The login
     */
    public int getLogin() {
        return login;
    }

    /**
     *
     * @param login
     * The login
     */
    public void setLogin(int login) {
        this.login = login;
    }

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
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

}