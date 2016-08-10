package id.padai.pertanian.detail;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.R;
import id.padai.pertanian.databinding.ActivityDetailBinding;

/**
 * Created by yogi on 09/06/16.
 */
public class DetailVM extends GitsVM<DetailController, ActivityDetailBinding> {


    TanamanDao tanamanDao;
    public ObservableField<String>bTextDetail = new ObservableField<>();
    public ObservableField<String>bImgUrl = new ObservableField<>();
    public DetailVM(AppCompatActivity activity, DetailController controller,
                    ActivityDetailBinding binding, TanamanDao tanamanDao) {
        super(activity, controller, binding);

        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }



    @BindingAdapter({"bind:showImage"})
    public static void loadImage(ImageView view, String image){
        Picasso.with(view.getContext()).load(image).placeholder(R.drawable.padi).into(view);
    }


    public void setData(TanamanDao tanamanDao) {
        mActivity.getSupportActionBar().setTitle(tanamanDao.nama);
        bTextDetail.set(tanamanDao.detail);
        bImgUrl.set(tanamanDao.image);
    }
}
