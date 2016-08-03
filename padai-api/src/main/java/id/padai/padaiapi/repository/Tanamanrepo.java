package id.padai.padaiapi.repository;

import java.util.List;

import id.padai.padaiapi.core.PadaiApi;
import id.padai.padaiapi.dao.TanamanDao;
import rx.Observable;

/**
 * Created by yogi on 09/06/16.
 */
public class Tanamanrepo {
    PadaiApi mPadaiApi;
    public int mId;

    public Tanamanrepo(PadaiApi padaiApi, int id){
        mPadaiApi=padaiApi;


    }

    public Observable<List<TanamanDao>> getTanaman(){
        return mPadaiApi.getApiService().getTanaman();
    }

    /*public Observable<TanamanDao> getDetailTanaman(){
        return mPadaiApi.getApiService().getDetailTanaman(mId);
    }*/
}
