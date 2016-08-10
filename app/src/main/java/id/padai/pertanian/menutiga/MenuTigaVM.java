package id.padai.pertanian.menutiga;

import android.app.ProgressDialog;
import android.databinding.BindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.padai.padaiapi.dao.TanamanDao;
import id.padai.pertanian.R;
import id.padai.pertanian.databinding.ActivityMenuTigaBinding;

/**
 * Created by yogi on 09/06/16.
 */
public class MenuTigaVM extends GitsVM<MenuTigaController,ActivityMenuTigaBinding> {
    private List<TanamanDao> mList= new ArrayList<>();
    public MenuTigaAdapter bAdapter;
    public LinearLayoutManager bLayoutManager;
    ProgressDialog  mProgressDialog;
    public MenuTigaVM(AppCompatActivity activity, MenuTigaController controller,
                      ActivityMenuTigaBinding binding, List<TanamanDao> mList) {
        super(activity, controller, binding);
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initAdapter(mList);
        callAPI();

    }

    private void initAdapter(List<TanamanDao> mList) {
        bAdapter= new MenuTigaAdapter(mList);
        bLayoutManager= new LinearLayoutManager(mActivity);

    }
    public void refreshAdapter(){
        bAdapter.notifyDataSetChanged();
    }
    public void callAPI(){
        mProgressDialog= ProgressDialog.show(mActivity,null,"Silakan tunggu");
        mController.callApi();
    }

    @BindingAdapter({"bind:showImage"})
    public static void loadImage(ImageView view, String image){
        Picasso.with(view.getContext()).load(image).placeholder(R.drawable.padi).into(view);
    }

    public void hideDialog() {
        mProgressDialog.dismiss();
    }
}
