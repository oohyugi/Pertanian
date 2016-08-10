package id.padai.pertanian.about;

import android.content.Context;
import android.content.Intent;

import id.gits.mvvmcore.activity.GitsActivity;
import id.padai.pertanian.R;

public class AboutActivity extends GitsActivity<AboutController> {



    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_about;
    }

    @Override
    protected AboutController createController() {
        return new AboutController();
    }
    public static void startActivity(Context context){
        context.startActivity(new Intent(context,AboutActivity.class));
    }
}
