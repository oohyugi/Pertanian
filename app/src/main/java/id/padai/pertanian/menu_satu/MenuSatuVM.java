package id.padai.pertanian.menu_satu;

import android.databinding.BindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.R;
import id.padai.pertanian.databinding.ActivityMenuSatuBinding;

/**
 * Created by yogi on 09/06/16.
 */
public class MenuSatuVM extends GitsVM<MenuSatuController,ActivityMenuSatuBinding> {
    private List<TanamanDao> mList= new ArrayList<>();
    public TanamanAdapter bAdapter;
    public LinearLayoutManager bLayoutManager;
    public MenuSatuVM(AppCompatActivity activity, MenuSatuController controller,
                      ActivityMenuSatuBinding binding, List<TanamanDao> mList) {
        super(activity, controller, binding);

        initAdapter(mList);
        callAPI();

    }

    private void initAdapter(List<TanamanDao> mList) {
        bAdapter= new TanamanAdapter(mList);
        bLayoutManager= new GridLayoutManager(mActivity,2);

    }
    public void refreshAdapter(){
        bAdapter.notifyDataSetChanged();
    }
    public void callAPI(){
        mController.callApi();
    }

    @BindingAdapter({"bind:showImage"})
    public static void loadImage(ImageView view, String image){
        Picasso.with(view.getContext()).load(image).placeholder(R.drawable.padi).into(view);
    }
}
