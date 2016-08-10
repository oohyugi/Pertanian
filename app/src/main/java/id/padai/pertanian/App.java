package id.padai.pertanian;

import android.app.Application;

import com.google.gson.Gson;

import id.padai.padaiapi.core.PadaiApi;

/**
 * Created by yogi on 05/06/16.
 */
public class App extends Application {
    public static PadaiApi padaiApi = new PadaiApi();
    public static Gson gson = new Gson();
    static String TAG="Result";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static PadaiApi getApi() {
        return padaiApi;
    }

    public static Gson getGson() {
        return gson;
    }

}
