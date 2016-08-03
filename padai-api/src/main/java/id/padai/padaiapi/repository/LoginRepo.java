package id.padai.padaiapi.repository;

import id.padai.padaiapi.core.PadaiApi;

/**
 * Created by yogi on 05/06/16.
 */
public class LoginRepo {

    PadaiApi mPadaiApi;
    String mU;
    String mP;
    String mK;

    public LoginRepo(PadaiApi padaiApi, String u, String p, String k){
        mPadaiApi=padaiApi;
        mU=u;
        mP=p;
        mK=k;

    }

   /* public Observable<BaseDao<List<LoginDao>>> postLogin(){
        return mPadaiApi.getApiService().postLogin(mU,mP,mK);

    }*/
}
