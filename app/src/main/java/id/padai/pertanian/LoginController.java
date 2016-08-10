package id.padai.pertanian;

import android.os.Bundle;
import android.util.Log;

import id.gits.mvvmcore.controller.GitsController;
import id.padai.padaiapi.core.MyObserver;
import id.padai.padaiapi.dao.BaseDao;
import id.padai.padaiapi.dao.LoginDao;
import id.padai.pertanian.dasboard.MainActivity;
import id.padai.pertanian.databinding.ActivityLoginBinding;
import id.padai.pertanian.utils.PrefHelper;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yogi on 05/06/16.
 */
public class LoginController extends GitsController<LoginVM, ActivityLoginBinding> {

    private String TAG="LOGIN";

    @Override
    public LoginVM createViewModel(ActivityLoginBinding binding) {
        return new LoginVM(mActivity,this,binding);
    }

    @Override
    public void bindViewModel(ActivityLoginBinding binding, LoginVM viewModel) {
        binding.setVm(viewModel);

    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {
        super.onCreateController(savedInstanceState);


    }

    public void callUser(final String bUserName, String bUserPass) {
        addSubscription(App.getApi().getApiService().postLogin(bUserName,bUserPass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<BaseDao<LoginDao>>() {
                    @Override
                    public void onApiResultCompleted() {
                        mViewModel.hideDialog();

                    }

                    @Override
                    public void onApiResultError(String message) {
                        Log.wtf(App.TAG, String.valueOf(message));
                        mViewModel.hideDialog();
                    }

                    @Override
                    public void onApiResultOk(BaseDao<LoginDao> loginDaoBaseDao) {

                        if (loginDaoBaseDao.STATUS_CODE==200){
                            Log.wtf(App.TAG, String.valueOf(loginDaoBaseDao.DATA.username));
                            PrefHelper.saveAccount(mActivity,loginDaoBaseDao.DATA);
                            mViewModel.hideDialog();
                            MainActivity.startActivity(mActivity);
                        }else{
                            Log.wtf(App.TAG, String.valueOf(loginDaoBaseDao.MESSAGE));
                        }

                //Log.wtf(App.TAG, String.valueOf(loginDaoBaseDao.STATUS));





            }


        }));

    }


    public void Register(String bUserName, String bUserPass) {
    }
}
