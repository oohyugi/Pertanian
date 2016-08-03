package id.padai.pertanian.menu_satu;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.R;
import id.padai.pertanian.databinding.RowMenuSatuBinding;
import id.padai.pertanian.detail.DetailActivity;

/**
 * Created by yogi on 09/06/16.
 */
public class TanamanAdapter extends GitsAdapter<TanamanDao,RowVM,RowMenuSatuBinding> {

    public TanamanAdapter(List<TanamanDao> collection){
        super(collection);
    }
    @Override
    public RowVM createViewModel(AppCompatActivity activity, RowMenuSatuBinding binding, TanamanDao item) {
        return new RowVM(activity,binding,item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_menu_satu;
    }

    @Override
    public void render(RowMenuSatuBinding binding, RowVM viewModel, TanamanDao item) {
        binding.setVm(viewModel);

    }

    @Override
    public void onRowClick(TanamanDao data, int position) {

        Log.wtf("Data", String.valueOf(data.getId()));
        DetailActivity.startActivity(mContext,data);
    }
}
