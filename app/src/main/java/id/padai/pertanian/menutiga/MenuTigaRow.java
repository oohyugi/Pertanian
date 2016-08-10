package id.padai.pertanian.menutiga;

import android.content.Context;
import android.databinding.ObservableField;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.databinding.RowMenuTigaBinding;

/**
 * Created by yogi on 09/06/16.
 */
public class MenuTigaRow extends GitsRowVM<TanamanDao,RowMenuTigaBinding> {
    public ObservableField<String>bTextNama = new ObservableField<>();
    public ObservableField<String>bImgUrl= new ObservableField<>();

    public MenuTigaRow(Context context, RowMenuTigaBinding binding, TanamanDao data) {
        super(context, binding, data);
        bTextNama.set(data.nama);
        bImgUrl.set(data.image);


    }
}
