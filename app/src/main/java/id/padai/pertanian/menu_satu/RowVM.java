package id.padai.pertanian.menu_satu;

import android.content.Context;
import android.databinding.ObservableField;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.databinding.RowMenuSatuBinding;

/**
 * Created by yogi on 09/06/16.
 */
public class RowVM extends GitsRowVM<TanamanDao,RowMenuSatuBinding> {
    public ObservableField<String>bTextNama = new ObservableField<>();
    public ObservableField<String>bImgUrl= new ObservableField<>();

    public RowVM(Context context, RowMenuSatuBinding binding, TanamanDao data) {
        super(context, binding, data);
        bTextNama.set(data.getNama());
        bImgUrl.set(data.getImage());


    }
}
