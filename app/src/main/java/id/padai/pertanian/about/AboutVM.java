package id.padai.pertanian.about;

import android.support.v7.app.AppCompatActivity;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.padai.pertanian.databinding.ActivityAboutBinding;

/**
 * Created by yogi on 10/08/16.
 */
public class AboutVM extends GitsVM<AboutController, ActivityAboutBinding> {
    public AboutVM(AppCompatActivity activity, AboutController controller, ActivityAboutBinding binding) {
        super(activity, controller, binding);
    }
}
