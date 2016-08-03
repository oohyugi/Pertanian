package id.padai.pertanian.detail;

import android.os.Bundle;
import android.util.Log;

import id.gits.mvvmcore.controller.GitsController;
import id.padai.padaiapi.core.MyObserver;
import id.padai.padaiapi.dao.BaseDao;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.App;
import id.padai.pertanian.databinding.ActivityDetailBinding;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yogi on 09/06/16.
 */
public class DetailController extends GitsController<DetailVM,ActivityDetailBinding> {
    private TanamanDao tanamanDao;
    private String nama;
    @Override
    public DetailVM createViewModel(ActivityDetailBinding binding) {
        return new DetailVM(mActivity,this,binding,tanamanDao);
    }

    @Override
    public void bindViewModel(ActivityDetailBinding binding, DetailVM viewModel) {
        binding.setVm(viewModel);

    }

    public void callAPI(final String id) {

        try {
            addSubscription(App.getApi().getApiService().getDetailTanaman("1")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new MyObserver<BaseDao<TanamanDao>>() {
                        @Override
                        public void onApiResultCompleted() {

                        }

                        @Override
                        public void onApiResultError(String message) {
                            Log.wtf("Error",message);

                        }

                        @Override
                        public void onApiResultOk(BaseDao<TanamanDao> tanamanDao) {
                            Log.wtf("sukses","sukses");
                            nama=tanamanDao.DATA.getNama();
                            mViewModel.setValue(tanamanDao.DATA);


                        }

                    }));
            Log.wtf("ID", String.valueOf(id));
        }catch (Exception e){
            e.printStackTrace();
            Log.wtf("ID", String.valueOf(e));


        }

    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {
        super.onCreateController(savedInstanceState);
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActivity.getSupportActionBar().setTitle("Padai");
    }
}
