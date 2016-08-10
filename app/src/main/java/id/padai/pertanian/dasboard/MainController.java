package id.padai.pertanian.dasboard;

import android.os.Bundle;

import id.gits.mvvmcore.controller.GitsController;
import id.padai.pertanian.LoginActivity;
import id.padai.pertanian.databinding.ActivityMainBinding;
import id.padai.pertanian.utils.PrefHelper;

/**
 * Created by yogi on 08/06/16.
 */
public class MainController extends GitsController<MainVM,ActivityMainBinding> {
    @Override
    public MainVM createViewModel(ActivityMainBinding binding) {
        return new MainVM(mActivity,this,binding);
    }

    @Override
    public void bindViewModel(ActivityMainBinding binding, MainVM viewModel) {
        binding.setVm(viewModel);

    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {
        super.onCreateController(savedInstanceState);
        if (PrefHelper.getAccount(mActivity)==null){
            LoginActivity.startActivity(mActivity);
            mActivity.finish();
        }
    }
}
