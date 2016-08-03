package id.padai.pertanian;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.gson.Gson;

import id.padai.padaiapi.core.PadaiApi;

/**
 * Created by yogi on 05/06/16.
 */
public class App extends Application {
    static PadaiApi padaiApi = new PadaiApi();
    static Gson sGson = new Gson();
    static String TAG="Result";

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }

    public static PadaiApi getApi() {
        return padaiApi;
    }

    public static Gson getGson() {
        return sGson;
    }

}
