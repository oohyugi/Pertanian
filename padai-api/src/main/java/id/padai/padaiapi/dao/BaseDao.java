package id.padai.padaiapi.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yogi on 31/05/16.
 */
public class BaseDao<T> {

    public boolean STATUS;
    public int STATUS_CODE;
    public MESSAGE message;
    public T DATA;
    private List<LOGIN> lOGIN = new ArrayList<LOGIN>();


    private class MESSAGE {
        public String PROD;
        public String DEVEL;
    }

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

   /*public class LoginDao {
        public String username;
        public int id;
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }*/
}

