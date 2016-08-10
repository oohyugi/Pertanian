package id.padai.padaiapi;

import java.util.List;

import id.padai.padaiapi.dao.BaseDao;
import id.padai.padaiapi.dao.LoginDao;
import id.padai.padaiapi.dao.TanamanDao;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yogi on 31/05/16.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("login.php")
    Observable<BaseDao<LoginDao>> postLogin(@Field("username") String username,
                                                  @Field("password") String password
    );

    @GET("get_data.php")
    Observable<BaseDao<List<TanamanDao>>> getTanaman(@Query("status") String status);

    @GET("get_kendali_hama_cabe.php")
    Observable<List<TanamanDao>> getHamaCabe();

    @GET("get_kendali_hama_padi.php")
    Observable<List<TanamanDao>> getHamaPadi();
    @GET("get_prosedur_cabe.php")
    Observable<List<TanamanDao>> getProsedurCabe();

    @GET("get_prosedur_padi.php")
    Observable<List<TanamanDao>> getProsedurPadi();




}
