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
                                                  @Field("password") String password,
                                                  @Field("kategori") String kategori);

    @GET("menusatu.php")
    Observable<List<TanamanDao>> getTanaman();

    @GET("menusatu_detail.php")
    Observable<BaseDao<TanamanDao>> getDetailTanaman(@Query("id") String id);


}
