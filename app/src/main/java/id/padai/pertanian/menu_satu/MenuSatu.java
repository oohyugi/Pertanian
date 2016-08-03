package id.padai.pertanian.menu_satu;

import android.content.Context;
import android.content.Intent;

import id.gits.mvvmcore.activity.GitsActivity;
import id.padai.pertanian.R;

public class MenuSatu extends GitsActivity<MenuSatuController> {



    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_menu_satu;
    }

    @Override
    protected MenuSatuController createController() {
        return new MenuSatuController();
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,MenuSatu.class);
        context.startActivity(intent);
    }
}
