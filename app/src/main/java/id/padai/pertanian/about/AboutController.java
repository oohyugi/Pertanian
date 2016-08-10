package id.padai.pertanian.about;

import id.gits.mvvmcore.controller.GitsController;
import id.padai.pertanian.databinding.ActivityAboutBinding;

/**
 * Created by yogi on 10/08/16.
 */
public class AboutController extends GitsController<AboutVM, ActivityAboutBinding> {
    @Override
    public AboutVM createViewModel(ActivityAboutBinding binding) {
        return new AboutVM(mActivity,this,binding);
    }

    @Override
    public void bindViewModel(ActivityAboutBinding binding, AboutVM viewModel) {
        binding.setVm(viewModel);

    }
}
