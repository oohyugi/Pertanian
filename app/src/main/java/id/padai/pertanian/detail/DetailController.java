package id.padai.pertanian.detail;

import android.os.Bundle;

import id.gits.mvvmcore.controller.GitsController;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.databinding.ActivityDetailBinding;

/**
 * Created by yogi on 09/06/16.
 */
public class DetailController extends GitsController<DetailVM,ActivityDetailBinding> {
    private TanamanDao tanamanDao;
    private static final String PARAM = "data";
    private String nama;
    @Override
    public DetailVM createViewModel(ActivityDetailBinding binding) {
        return new DetailVM(mActivity,this,binding,tanamanDao);

    }

    @Override
    public void bindViewModel(ActivityDetailBinding binding, DetailVM viewModel) {
        binding.setVm(viewModel);

    }





    @Override
    public void onCreateController(Bundle savedInstanceState) {
        super.onCreateController(savedInstanceState);

        tanamanDao =(TanamanDao)mActivity.getIntent().getSerializableExtra(PARAM);
        mViewModel.setData(tanamanDao);


    }
}
