package id.padai.padaiapi.core;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yogi on 31/05/16.
 */
public class ApiInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest= chain.request();
        Request requestWithuserAgent= originalRequest.newBuilder().build();
        System.out.print("API START" + chain.request().url().toString());

        return chain.proceed(requestWithuserAgent);
    }
}
