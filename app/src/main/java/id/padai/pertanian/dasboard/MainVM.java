package id.padai.pertanian.dasboard;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.padai.pertanian.about.AboutActivity;
import id.padai.pertanian.databinding.ActivityMainBinding;
import id.padai.pertanian.menu_satu.MenuSatu;
import id.padai.pertanian.menutiga.MenuTiga;

/**
 * Created by yogi on 08/06/16.
 */
public class MainVM extends GitsVM<MainController,ActivityMainBinding> {
    public MainVM(AppCompatActivity activity, MainController controller, ActivityMainBinding binding) {
        super(activity, controller, binding);
    }

    public void onClickTanaman(View view){
        MenuSatu.startActivity(mActivity,"1");

    }
    public void onClickProsedur(View view){
        MenuTiga.startActivity(mActivity,"4");


    }
    public void onClickSchedule(View view){

    }
    public void onClickkendaliHama(View view){
        MenuTiga.startActivity(mActivity,"7");

    }
    public void onClickDiskusi(View view){

    }
    public void onClickAbout(View view){
        AboutActivity.startActivity(mActivity);

    }
}
