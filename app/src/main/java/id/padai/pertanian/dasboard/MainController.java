package id.padai.pertanian.dasboard;

import id.gits.mvvmcore.controller.GitsController;
import id.padai.pertanian.databinding.ActivityMainBinding;

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
}
