package id.padai.padaiapi.core;

import java.util.concurrent.TimeUnit;

import id.padai.padaiapi.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yogi on 31/05/16.
 */
public class PadaiApi {

    public static final String BASE_URL="http://10.42.0.1/ta_dara/";
    ApiService apiService;

    public PadaiApi(){
        OkHttpClient client= new OkHttpClient.Builder()
                .addInterceptor(new ApiInterceptor())
                .readTimeout(300, TimeUnit.SECONDS)
                .connectTimeout(300, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit= new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build();

        apiService= retrofit.create(ApiService.class);

    }

    public ApiService getApiService() {
        return apiService;
    }
}
