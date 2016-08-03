package id.padai.pertanian.dasboard;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.padai.pertanian.databinding.ActivityMainBinding;
import id.padai.pertanian.menu_satu.MenuSatu;

/**
 * Created by yogi on 08/06/16.
 */
public class MainVM extends GitsVM<MainController,ActivityMainBinding> {
    public MainVM(AppCompatActivity activity, MainController controller, ActivityMainBinding binding) {
        super(activity, controller, binding);
    }

    public void onClickTanaman(View view){
        MenuSatu.startActivity(mActivity);

    }
    public void onClickProsedur(View view){

    }
    public void onClickSchedule(View view){

    }
    public void onClickkendaliHama(View view){

    }
    public void onClickDiskusi(View view){

    }
    public void onClickAbout(View view){

    }
}
