package id.padai.pertanian.menutiga;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.R;
import id.padai.pertanian.databinding.RowMenuTigaBinding;
import id.padai.pertanian.menu_satu.MenuSatu;

/**
 * Created by yogi on 09/06/16.
 */
public class MenuTigaAdapter extends GitsAdapter<TanamanDao,MenuTigaRow,RowMenuTigaBinding> {

    public MenuTigaAdapter(List<TanamanDao> collection){
        super(collection);
    }
    @Override
    public MenuTigaRow createViewModel(AppCompatActivity activity, RowMenuTigaBinding binding, TanamanDao item) {
        return new MenuTigaRow(activity,binding,item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_menu_tiga;
    }

    @Override
    public void render(RowMenuTigaBinding binding, MenuTigaRow viewModel, TanamanDao item) {
        binding.setVm(viewModel);

    }

    @Override
    public void onRowClick(TanamanDao data, int position) {

        Log.wtf("Data", String.valueOf(data.id));
        MenuSatu.startActivity(mContext,data.id);
    }
}
