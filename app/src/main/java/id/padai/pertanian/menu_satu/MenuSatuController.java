package id.padai.pertanian.menu_satu;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.controller.GitsController;
import id.padai.padaiapi.core.MyObserver;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.App;
import id.padai.pertanian.databinding.ActivityMenuSatuBinding;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yogi on 09/06/16.
 */
public class MenuSatuController extends GitsController<MenuSatuVM,ActivityMenuSatuBinding> {
    private List<TanamanDao>mList= new ArrayList<>();
    @Override
    public MenuSatuVM createViewModel(ActivityMenuSatuBinding binding) {
        return new MenuSatuVM(mActivity,this,binding,mList);
    }

    @Override
    public void bindViewModel(ActivityMenuSatuBinding binding, MenuSatuVM viewModel) {
        binding.setVm(viewModel);

    }



    public void callApi() {

        //Tanamanrepo mTanamanrepo = new Tanamanrepo(App.getApi());
        addSubscription(App.getApi().getApiService().getTanaman()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<List<TanamanDao>>() {
            @Override
            public void onApiResultCompleted() {

            }

            @Override
            public void onApiResultError(String message) {
               Log.wtf("Error",message);

            }

            @Override
            public void onApiResultOk(List<TanamanDao> tanamanDaos) {
                Log.wtf("Suskes","suskes");
                mList.addAll(tanamanDaos);
                mViewModel.refreshAdapter();


            }
        }));
    }
}
